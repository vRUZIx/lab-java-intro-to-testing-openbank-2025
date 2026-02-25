import java.util.Arrays;
public class Java_keywords {

        public boolean Java_Keywords(String sentences) {
            String[] javaKeywords = {
                    "abstract", "assert", "boolean", "break", "byte",
                    "case", "catch", "char", "class", "continue",
                    "default", "do", "double", "else", "enum",
                    "extends", "final", "finally", "float", "for",
                    "if", "implements", "import", "instanceof", "int",
                    "interface", "long", "native", "new", "package",
                    "private", "protected", "public", "return", "short",
                    "static", "strictfp", "super", "switch", "synchronized",
                    "this", "throw", "throws", "transient", "try",
                    "void", "volatile", "while"
            };
            if(sentences.isEmpty()){

                return false;
            }
            String[] sentenceArr=sentences.split("[,:; ]");

            for(String word : sentenceArr) {
                if(Arrays.asList(javaKeywords).contains(word.toLowerCase())){
                    return true;
                }
            }
            return false;
        }
    }
