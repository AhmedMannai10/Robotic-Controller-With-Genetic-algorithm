package v1;

import javax.print.attribute.standard.RequestingUserName;
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
