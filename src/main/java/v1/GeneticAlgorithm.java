package v1;

public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    public GeneticAlgorithm(int populationSize,
                            double mutationRate,
                            double crossoverRate,
                            int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    public Population initPopulation(int chromosomeLength){
        Population population = new Population(this.populationSize, chromosomeLength);
        return population;
    }

    public boolean isTerminationConditionMet(Population population){
        for(Individual individual : population.getIndividuals()){
            if(individual.getFitness() == 1){
                return true;
            }
        }
        return false;
    }


    public double calcFitness(Individual individual){
        // Track number of correct genes;
        int correctGenes = 0;

        //loop over individual's genes
        for(int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++){
            // fitness ++
            if(individual.getGene(geneIndex) == 1){
                correctGenes += 1;
            }
        }

        // calculate fitness
        double fitness = (double) correctGenes / individual.getChromosomeLength();

        individual.setFitness(fitness);

        return fitness;
    }

    public void evalPopulation(Population population){
        double populationFitness = 0;

        for(Individual individual : population.getIndividuals()){
            populationFitness += calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }

    // Crossover Implementation
    public Individual selectParent(Population population){
        // Get Individuals
        Individual individuals[] = population.getIndividuals();

        // spin roulette wheel
        double populationFitness = population.getPopulationFitness();
        double rouletteWheelPosition = Math.random() * populationFitness /2 ;

        // find parent
        double spinWheel = 0;

        for(Individual individual : individuals){

            spinWheel = spinWheel +  calcFitness(individual);
            if(spinWheel >= rouletteWheelPosition){
                System.out.println(individual.toString());
                return individual;
            }
        }
        return individuals[population.size() - 1];
    }

    public Population crossoverPopulation(Population population){
        // Create new population
        Population newPopulation = new Population(population.size());

        // Loop over current population by fitness
        for(int populationIndex = 0; populationIndex < population.size(); populationIndex++){
            Individual parent1 = population.getFittest(populationIndex);

            // Applying crossover to this individual if ==>
            if(this.crossoverRate > Math.random() && populationIndex > this.elitismCount){
                // Initialize offspring
                Individual offspring = new Individual(parent1.getChromosomeLength());

                // Find second parent
                Individual parent2 = selectParent(population);

                // loop over genome
                for(int geneIndex  = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++){

                    // Use half of parent1's genes and half of parent2's genes
                    if(0.5 > Math.random()){
                        offspring.setGene(geneIndex, parent1.getGene(geneIndex));
                    }else{
                        offspring.setGene(geneIndex, parent2.getGene(geneIndex));
                    }
                }
                // add individual to the new population
                newPopulation.setIndividual(populationIndex, offspring);

            }else{
                // add individual to the new population without applying crossover
                newPopulation.setIndividual(populationIndex, parent1);
            }
        }
        return newPopulation;
    }
}
