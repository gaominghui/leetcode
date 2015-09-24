package git_test;

public class WordDictionary {

	Trie root;
    // Adds a word into the data structure.
    public WordDictionary(){
    	root=new Trie();
    }
	public void addWord(String word) {
        Trie current=root;
        int len=word.length();
        for(int i=0;i<len;i++){
        	if(current.next[word.charAt(i)-'a']==null){
        		current.next[word.charAt(i)-'a']=new Trie();
        	}
        	current=current.next[word.charAt(i)-'a'];
        }
        current.isWord=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(word,0,root);
    }
    public boolean searchHelper(String word,int index,Trie root){
    	if(root==null || word.length()==index&&root.isWord==false)return false;
    	if(word.length()==index &&root.isWord==true)return true;
    	if(word.charAt(index)=='.'){
    		
    		for(int i=0;i<26;i++){
    			boolean re=searchHelper(word,index+1,root.next[i]);
    			if(re)return true;
    		}
    		return false;
    	}else{
    		return searchHelper(word,index+1,root.next[word.charAt(index)-'a']);
    	}
    	
    	
    	
    	
    }
    
    
    public static void main(String[]args){
    	WordDictionary dic=new WordDictionary();
    	dic.addWord("a");
    	boolean ret=dic.search(".");
    	System.out.println(ret);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
