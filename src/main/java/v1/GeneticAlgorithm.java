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
                correctGenes ++;
            }

        }

        // calculate fitness
        double fitness = (double) correctGenes / individual.getChromosomeLength();

        return fitness;
    }

    public void evalPopulation(Population population){
        double populationFitness = 0;

        for(Individual individual : population.getIndividuals()){
            populationFitness += calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }
}
