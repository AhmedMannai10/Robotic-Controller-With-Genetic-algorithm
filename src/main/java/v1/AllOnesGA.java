package v1;

import java.util.Arrays;

public class AllOnesGA {
    public static void main(String[] args){
        // Create GA object
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.95, 0);

        //Initialize population
        Population population = ga.initPopulation(50);

        ga.evalPopulation(population);
        int generation = 1;

//        System.out.println(Arrays.toString(population.getIndividuals()));

        while(ga.isTerminationConditionMet(population) == false){
            //Print fittest individual from population
            System.out.println("Best solution: - " + population.getFittest(0).toString());


            //Apply crossover
            population = ga.crossoverPopulation(population);


            // Apply mutation
            // TODO!

            //Evaluate population
            ga.evalPopulation(population);

            //Increment the current generation
            generation++;
        }

        System.out.println("Found solution in " + generation + " generations");
        System.out.println("Best solution: " + population.getFittest(0).toString());


    }



}
