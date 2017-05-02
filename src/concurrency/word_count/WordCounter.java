package concurrency.word_count;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class WordCounter {

	String[] wordsIn(String line) {
		return line.trim().split("(\\s|\\p{Punct})+");
	}

	Long occurrencesCount(Document document, String searchedWord) {
		long count = 0;
		for (String line : document.getLines()) {
			for (String word : wordsIn(line)) {
				if (searchedWord.equals(word)) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	Long countOccurrencesOnSingleThread(Folder folder, String searchedWord) {
		long count = 0;
		for (Folder subFolder : folder.getSubFolders()) {
			count = count + countOccurrencesOnSingleThread(subFolder, searchedWord);
		}
		for (Document document : folder.getDocuments()) {
			count = count + occurrencesCount(document, searchedWord);
		}
		return count;
	}

	private final ForkJoinPool forkJoinPool = new ForkJoinPool();

	Long countOccurrencesInParallel(Folder folder, String searchedWord) {
		return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
	}

	public static void main(String[] args) throws IOException {
		
		/*
		 * ponemos los argumentos a pelo en el código
		 */
		args = new String[3];
		args[0] = "data";
		args[1] = "desire";
		args[2] = "1";
		
		WordCounter wordCounter = new WordCounter();
		Folder folder = Folder.fromDirectory(new File(args[0]));

		final int repeatCount = Integer.decode(args[2]);
		long counts;
		long startTime;
		long stopTime;

		long[] singleThreadTimes = new long[repeatCount];
		long[] forkedThreadTimes = new long[repeatCount];

		for (int i = 0; i < repeatCount; i++) {
			startTime = System.currentTimeMillis();
			counts = wordCounter.countOccurrencesOnSingleThread(folder, args[1]);
			stopTime = System.currentTimeMillis();
			singleThreadTimes[i] = (stopTime - startTime);
			System.out.println(counts + " , single thread search took " + singleThreadTimes[i] + "ms");
		}

		for (int i = 0; i < repeatCount; i++) {
			startTime = System.currentTimeMillis();
			counts = wordCounter.countOccurrencesInParallel(folder, args[1]);
			stopTime = System.currentTimeMillis();
			forkedThreadTimes[i] = (stopTime - startTime);
			System.out.println(counts + " , fork / join search took " + forkedThreadTimes[i] + "ms");
		}

		System.out.println("\nCSV Output:\n");
		System.out.println("Single thread,Fork/Join");
		for (int i = 0; i < repeatCount; i++) {
			System.out.println(singleThreadTimes[i] + "," + forkedThreadTimes[i]);
		}
		System.out.println();
	}

}
