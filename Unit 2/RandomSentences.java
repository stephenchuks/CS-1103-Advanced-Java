import java.util.Scanner;
public class RandomSentences {

    //proper nouns
    static final String[] proper_noun = { "Richard Nixon", "Jagat", "Fred", "Miss America"};
    //common nouns
    static final String[] common_noun = { "woman", "man", "dog", "elephant", "unicorn"};
    //conjunctions
    static final String[] conj = { "and", "or", "but", "due to"};
    //determiner
    static final String[] det = { "a", "the", "every", "some"};
    //adjective
    static final String[] adj = { "big", "tiny", "pretty", "bald"};
    //transitive verb
    static final String[] trn_verb = { "runs", "jumps", "talks", "sleeps"};
    //intransitive verb
    static final String[] int_verb = { "loves", "hates", "swims", "knows", "looks for", "finds"};

    public static void main(String[] args) {
        while (true) {
            //calling the first subroutine for generating sentences
            simpleSentence();
            System.out.println(".\n\n");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
            }
        }

    }


    static void simpleSentence() {
        int cj = (int)(Math.random()*conj.length);
        //generating basic sentence using noun and verb phrase
        if (Math.random() > 0.2){
            randomNounPhrase();
            randomVerbPhrase();
        }
        //recursively making compound sentences using conjunctions
        if (Math.random() > 0.75) {
            System.out.print(" " + conj[cj]);
            simpleSentence();
        }
    }

    static void randomNounPhrase() {

        //assigning random probability to each of the noun phrase elements
        int pn = (int)(Math.random()*proper_noun.length);
        int cn = (int)(Math.random()*common_noun.length);
        int dt = (int)(Math.random()*det.length);
        int ad = (int)(Math.random()*adj.length);

        if (Math.random() > 0.5)
            System.out.print(" " + proper_noun[pn]);//displaying a proper noun first
        else{
            System.out.print(" " + det[dt]);//or a determiner

            if (Math.random() > 0.5)
                System.out.print(" " + adj[ad]);//with an optional adjective

            System.out.print(" " + common_noun[cn]);//with a common noun after adjective

            if (Math.random() > 0.75){
                System.out.print(" who");//with an optional who clause with random verb phrase
                randomVerbPhrase();
            }
        }
    }

    static void randomVerbPhrase() {
        //assigning random probability to each of the verb phrase elements
        int tv = (int)(Math.random()*trn_verb.length);
        int iv = (int)(Math.random()*int_verb.length);
        int adv = (int)(Math.random()*adj.length);

        if (Math.random() > 0.5)
            System.out.print(" " + trn_verb[tv]);//displaying transitive verb
        else if (Math.random() > 0.4) {
            System.out.print(" " + int_verb[iv]);//or an intransitive verb based on random value
            randomNounPhrase();//intransitive verb always with a noun phrase
        }
        else if (Math.random() > 0.3)
            System.out.print(" is " + adj[adv]);// or "is" followed by an adjective
        else{
            System.out.print(" believes that");
            simpleSentence(); //or "believes that" with another simple sentence
        }
    }

}