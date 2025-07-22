public class TextProcessor {
    public static int countWords(String sentence){
        if(sentence == null){
            return 0;
        }

        String trimmedSentence = sentence.trim();
        if (trimmedSentence.isEmpty()) {
            return 0;
        }

        String[] words = trimmedSentence.split("\\s+");

        return words.length;
    }

    public static String replaceWord(String text, String oldWord,String newWord){
        if(text == null){
            return null;
        }

        if(oldWord == null || oldWord.isEmpty()){
            return text;
        }
        return text.replace(oldWord,newWord);
    }

    public static void main(String[] args){
        String text = "Java is fun and Java is powerful";

        System.out.println("Words count "+countWords(text));
        System.out.println(replaceWord(text,"Java","Programming"));
    }
}
