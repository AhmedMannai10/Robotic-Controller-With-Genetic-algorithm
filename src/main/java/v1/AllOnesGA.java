package v1;

public class AllOnesGA {
    public static void main(String[] args){
        // Create GA object
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.95, 0);

        //Initialize population
        Population population = ga.initPopulation(50);


        // Apply crossover
        // TODO!

        // Apply mutation
        // TODO!

        //Evaluate population
        ga.evalPopulation(population);

        //Increment the current generation
    }



}
