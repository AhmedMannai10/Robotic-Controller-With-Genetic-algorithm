package v1;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
    private Individual population[];
    private double populationFitness = -1;

    public Population(int populationSize){
        this.population = new Individual[populationSize];
    }

    public Population(int populationSize, int chromosomeLength){
        this.population = new Individual[populationSize];

        for(int individualCount = 0; individualCount < populationSize; individualCount ++){
            Individual individual = new Individual(chromosomeLength);
            this.population[individualCount] = individual;
        }
    }

    public Individual[] getIndividuals() {
        return population;
    }

    public double getPopulationFitness() {
        return populationFitness;
    }

    public void setPopulationFitness(double populationFitness) {
        this.populationFitness = populationFitness;
    }

    public int size(){
        return this.population.length ;
    }

    public Individual getFittest(int offset){
        Arrays.sort(this.population, new Comparator<Individual>(){
            @Override
            public int compare(Individual o1, Individual o2) {
                if(o1.getFitness()  > o2.getFitness()){
                    return -1;
                }else if(o1.getFitness() < o1.getFitness()){
                    return 1;
                }
                return 0;
            }
        });
        return this.population[offset];
    }

    public Individual setIndividual(int offset, Individual individual){
        return population[offset] = individual;
    }
    public Individual getIndividual(int offset){
        return population[offset];
    }

    public void shuffle(){
        Random rnd = new Random();

        for(int i = population.length - 1 ; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            Individual a = population[index];
            population[i] = a;
        }
    }

}
