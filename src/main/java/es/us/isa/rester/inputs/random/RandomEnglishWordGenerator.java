package es.us.isa.rester.inputs.random;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;

/**
 * @author Sergio Segura
 *
 */
public class RandomEnglishWordGenerator extends RandomGenerator {

	private final String[] LINKING_WORDS = {"the","a","and","so","for","of","hence","thus","if"};
	private Dictionary dictionary;
	private int minWords=1;
	private int maxWords=3;
	private boolean generateCompounds=true;
	private boolean ignoreLinkindWords=true;
	private POS category=null; // Requested category:  NOUN, VERB, ADJECTIVE, ADVERB
	
    public RandomEnglishWordGenerator() {
    	super();
    	
    	try {
			this.dictionary = Dictionary.getDefaultResourceInstance();
			
		} catch (JWNLException e) {
			System.err.println("Error instantiating JWNL ditionary");
			e.printStackTrace();
		}
    }
    
    public RandomEnglishWordGenerator(int minWords, int maxWords) {
    	this();
    	this.minWords = minWords;
    	this.maxWords = maxWords;
    }
   
	@Override
	public String nextValue() {
		
		StringBuilder generatedString=new StringBuilder();
		
		// Calculate number of words
		int nWords=calculateNumberOfWords();

		// Generate words
		try {
			int i=0;
			while (i<nWords) {
				
				// Select word category (ex. verb, adjective or random)
	            if(getCategory()==null)
	            	category = POS.getAllPOS().get(rand.nextInt(0,POS.getAllPOS().size()-1));
	            
	            // Generate word
	            IndexWord dictionaryEntry=dictionary.getRandomIndexWord(category);
	            if (!generateCompounds)
	            	while (numberOfWords(dictionaryEntry.getLemma()) > 1)
	            		dictionaryEntry = dictionary.getRandomIndexWord(category);
	            
	            
	           //System.out.println("Number of words: " + nWords + " - Generated word: " + generatedString.toString() + " (" + numberOfWords(generatedString.toString()) + ") - Current random word: " + dictionaryEntry.getLemma() + " (" + numberOfWords(dictionaryEntry.getLemma()) + ")");
	            
	            if ((numberOfWords(generatedString.toString()) + numberOfWords(dictionaryEntry.getLemma())) <= nWords) // Check it does not exceed the maximum number of words
	            	if (!excludeWords(dictionaryEntry.getLemma())){		// Check the word is not in the list of excluded words
	            		generatedString.append(dictionaryEntry.getLemma());
		            	i+=numberOfWords(dictionaryEntry.getLemma());
		            	if (i<nWords)
		            		generatedString.append(" ");
	            	}
	         }
        } catch (JWNLException ex) {
            System.err.println("Error generating random words: " + ex.getMessage());
            ex.printStackTrace();
        }
        return generatedString.toString().trim();
	}
	
	@Override
	public String nextValueAsString() {
		return nextValue();
	}

	private int numberOfWords(String sentence) {
		String trimmed = sentence.trim();
		int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		return words;
	}

	private boolean excludeWords(String sentence) {
			
		boolean result=false;
		
		if (ignoreLinkindWords) {
			for(int i=0;i<LINKING_WORDS.length && !result;i++)
	            if(LINKING_WORDS[i].equalsIgnoreCase(sentence))
	                result=true;
		}
		
        return result;
	}

	private int calculateNumberOfWords() {
		return rand.nextInt(minWords, maxWords);
	}

	public boolean isIgnoreLinkindWords() {
		return ignoreLinkindWords;
	}

	public void setIgnoreLinkindWords(boolean ignoreLinkindWords) {
		this.ignoreLinkindWords = ignoreLinkindWords;
	}

	public int getMinWords() {
		return minWords;
	}

	public void setMinWords(int minWords) {
		this.minWords = minWords;
	}

	public int getMaxWords() {
		return maxWords;
	}

	public void setMaxWords(int maxWords) {
		this.maxWords = maxWords;
	}

	public POS getCategory() {
		return category;
	}

	public void setCategory(POS category) {
		this.category = category;
	}

	public boolean generateCompounds() {
		return generateCompounds;
	}

	public void setGenerateCompounds(boolean generateCompounds) {
		this.generateCompounds = generateCompounds;
	}
}
