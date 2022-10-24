package v1;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual (int[] chromosome){
        // Create individual chromosome
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength){
        this.chromosome = new int[chromosomeLength];

        for(int gene = 0;  gene < chromosomeLength; gene++){
            if(0.5 < Math.random()){
                this.setGene(gene, 1);
            }else{
                this.setGene(gene, 0);
            }
        }
    }

    public void setGene(int offset , int gene){
        this.chromosome[offset] = gene;
    }

    public int getGene(int offset){
        return this.chromosome[offset];
    }

    public int[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    public int getChromosomeLength(){
        return this.chromosome.length;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }


}
