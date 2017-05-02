package concurrency.word_count;

import java.util.concurrent.RecursiveTask;

public class DocumentSearchTask extends RecursiveTask<Long> {
	private final Document document;
    private final String searchedWord;
    
    DocumentSearchTask(Document document, String searchedWord) {
        super();
        this.document = document;
        this.searchedWord = searchedWord;
    }
    
    @Override
    protected Long compute() {
    	WordCounter wordCounter = new WordCounter();
        return wordCounter.occurrencesCount(document, searchedWord);
    }
}
