package robotController;


import v1.Individual;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
    private v1.Individual population[];
    private double populationFitness = -1;

    public Population(int populationSize){
        this.population = new v1.Individual[populationSize];
    }

    public Population(int populationSize, int chromosomeLength){
        this.population = new v1.Individual[populationSize];

        for(int individualCount = 0; individualCount < populationSize; individualCount ++){
            v1.Individual individual = new v1.Individual(chromosomeLength);
            this.population[individualCount] = individual;
        }
    }

    public v1.Individual[] getIndividuals() {
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

    public v1.Individual getFittest(int offset){
        Arrays.sort(this.population, new Comparator<v1.Individual>(){
            @Override
            public int compare(v1.Individual o1, v1.Individual o2) {
                if(o1.getFitness()  > o2.getFitness()){
                    return -1;
                }else if(o1.getFitness() < o1.getFitness()){
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(population));
        return this.population[offset];
    }

    public v1.Individual setIndividual(int offset, v1.Individual individual){
        return population[offset] = individual;
    }
    public v1.Individual getIndividual(int offset){
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
