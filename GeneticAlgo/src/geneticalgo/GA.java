package geneticalgo;
import java.util.*;

public class GA {
    public static ArrayList<String> letters = new ArrayList<>();
    
    public static void importLetters(boolean capsNum){
        
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        letters.add("g");
        letters.add("h");
        letters.add("i");
        letters.add("j");
        letters.add("k");
        letters.add("l");
        letters.add("m");
        letters.add("n");
        letters.add("o");
        letters.add("p");
        letters.add("q");
        letters.add("r");
        letters.add("s");
        letters.add("t");
        letters.add("u");
        letters.add("v");
        letters.add("w");
        letters.add("x");
        letters.add("y");
        letters.add("z");
        letters.add(" ");
        if(capsNum){
            letters.add("A");
            letters.add("B");
            letters.add("C");
            letters.add("D");
            letters.add("E");
            letters.add("F");
            letters.add("G");
            letters.add("H");
            letters.add("I");
            letters.add("J");
            letters.add("K");
            letters.add("L");
            letters.add("M");
            letters.add("N");
            letters.add("O");
            letters.add("P");
            letters.add("Q");
            letters.add("R");
            letters.add("S");
            letters.add("T");
            letters.add("U");
            letters.add("V");
            letters.add("W");
            letters.add("X");
            letters.add("Y");
            letters.add("Z");
            letters.add("1");
            letters.add("2");
            letters.add("3");
            letters.add("4");
            letters.add("5");
            letters.add("6");
            letters.add("7");
            letters.add("8");
            letters.add("9");
            letters.add("0"); 
        }
        System.out.println("Letters imported.");
    }
    
    public static ArrayList<Phrase> generateFirstPopulation(String phrase,int populationSize){
        
        ArrayList<Phrase> newPopulation = new ArrayList<>();
        System.out.println("");
        System.out.println("GA.generateFirstPopulation: GENERATING FIRST POPULATION");
        boolean timeout = false;
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < populationSize; i++){
            
            Phrase newPhrase = new Phrase(createNewString(phrase.length()), 0);
            newPopulation.add(newPhrase);
            double endTime = System.currentTimeMillis();
            if((endTime - startTime) > 5000){
                timeout = true;
                break;
            }
        }
        if(timeout){
            return null;
        }
        
        return newPopulation;
    }
    
    public static ArrayList<Phrase> assignFitness(ArrayList<Phrase> population, String desiredPhrase){
        ArrayList<Phrase> newPopulation = new ArrayList<>();
        for(int index = 0; index < population.size(); index++){
            double fitness = getFitness(population.get(index), desiredPhrase);
            Phrase newPhrase = new Phrase(population.get(index).getPhrase(), fitness);
            newPopulation.add(newPhrase);
        }
        return newPopulation;
    }
    
    public static double getFitness(Phrase phrase, String desiredPhrase){
        double fitness = phrase.getPhrase().length() * 27;
        for(int i = 0; i < phrase.getPhrase().length(); i++){
            int phraseIndex = getIndex(phrase.getPhrase().substring(i, i + 1));
            int desiredIndex = getIndex(desiredPhrase.substring(i,i+1));
            
            fitness -= Math.abs(desiredIndex - phraseIndex);
        }
        //System.out.println("GA.getFitness: phrase: " + phrase.getPhrase() + " fitness: " + fitness);
        return fitness;
    }
    
    public static int getIndex(String letter){
        int index;
        for(index = letters.size() - 1; index > 0; index--){
            if(letters.get(index).equals(letter)){
                return index;
            }
        }
        return -1;
    }
    
    public static ArrayList<Phrase> generatePopulation(ArrayList<Phrase> population, double mutationRate){
        ArrayList<Phrase> oldPopulation = new ArrayList<Phrase>();
        //import population into oldPopulation
        for(Phrase phrase: population){
            oldPopulation.add(phrase);
        }
        
        Phrase mate1 = findHighestFitness(oldPopulation);
        //remove mate1
        for(int i = oldPopulation.size() - 1; i > 0;i--){
            if(oldPopulation.get(i).getPhrase().equals(mate1.getPhrase())){
                oldPopulation.remove(i);
            }
        }
        
        Phrase mate2 = findHighestFitness(oldPopulation);
        //remove mate2
        for(int i = oldPopulation.size() - 1; i > 0;i--){
            if(oldPopulation.get(i).getPhrase().equals(mate2.getPhrase())){
                oldPopulation.remove(i);
            }
        }
        
        ArrayList<Phrase> newPopulation = new ArrayList<>();
        
        for(int i = 0; i < population.size(); i++){
            Phrase newChild = mate(mate1,mate2, mutationRate);
            System.out.println("child created: " + newChild.getPhrase());
            newPopulation.add(newChild);
        }
        
        return newPopulation;
        
    }
    
    public static Phrase findHighestFitness(ArrayList<Phrase> population){
        Phrase highestFitness = new Phrase("", 0);
        for(Phrase phrase: population){
            if(phrase.getFitness() > highestFitness.getFitness()){
                highestFitness = phrase;
            }
        }
        return highestFitness;
    }
    
    public static String createNewString(int size){
        String newString = "";
        for(int i = 0; i < size; i++){
            newString = newString + randomLetter();
        }
        return newString;
    }
    
    public static String randomLetter(){
        int random = (int)(Math.random() * letters.size());
        return letters.get(random);
    }
    
    public static Phrase mate(Phrase mate1, Phrase mate2, double mutationRate){
        String newString = "";
        
        for(int i = 0; i < mate1.getPhrase().length(); i++){
            if(i % 2 == 0){
                if(Math.random() > mutationRate){
                    newString = newString + mate1.getPhrase().substring(i, i+1);
                }else{
                    newString = newString + randomLetter();
                }
                
            }else{
                if(Math.random() > mutationRate){
                    newString = newString + mate2.getPhrase().substring(i, i+1);
                }else{
                    newString = newString + randomLetter();
                }
            }
            
        }
        return new Phrase(newString, 0);
    }

    public static ArrayList<Phrase> sortList(ArrayList<Phrase> population){
        Phrase removed;
        int index;
        ArrayList<Phrase> newPopulation = new ArrayList<>();
        for(int k = 0; k < newPopulation.size() - 1; k++){
            index = k;
            for(int i = k + 1; i < newPopulation.size(); i++){
        	if(newPopulation.get(index).getFitness() > newPopulation.get(i).getFitness()){
        	    index = i;
        	}else if(newPopulation.get(index).getFitness() == newPopulation.get(i).getFitness()){
        	    if(Math.random() > 0.5){
        	        index = i;
        	    }
        	}
            }
            removed = newPopulation.get(k);
            newPopulation.set(k, newPopulation.get(index));
            newPopulation.set(index, removed);
        }
        return newPopulation;
    }
                
}


//Sort based on fitness
//Belongs in generatePopulation, but might not be used.
/*
Phrase removed;
int index;
for(int k = 0; k < newPopulation.size() - 1; k++){
    index = k;
    for(int i = k + 1; i < newPopulation.size(); i++){
        if(newPopulation.get(index).getFitness() > newPopulation.get(i).getFitness()){
            index = i;
        }else if(newPopulation.get(index).getFitness() == newPopulation.get(i).getFitness()){
            if(Math.random() > 0.5){
            	index = i;
            }
        }
    }
    removed = newPopulation.get(k);
    newPopulation.set(k, newPopulation.get(index));
    newPopulation.set(index, removed);
}
*/