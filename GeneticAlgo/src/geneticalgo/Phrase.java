
package geneticalgo;

public class Phrase {
    
    private String phrase;
    private double fitness;
    
    public Phrase(String phrase,double fitness){
        this.fitness = fitness;
        if(fitness < 0.01){
            this.fitness = fitness;
        }
        this.phrase = phrase;
    }
    
    public String getPhrase(){
        return phrase;
    }
    
    public Double getFitness(){
        return fitness;
    }
    
    public void setFitness(double fitness){
        this.fitness = fitness;
    }
}
