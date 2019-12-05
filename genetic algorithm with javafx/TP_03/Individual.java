package TP_03;

/**
 *
 * @author IlyesMax
 */
public class Individual {
    
private int[] chromosome;
   private double fitness=-1;

	//creer un individual avec un tableau des chromosomes
	public Individual(int[] chromosome) {
			this.chromosome = chromosome;
	}
        //remplir le tableau des chromosomes
	public Individual(int chromosomeLength) {

		this.chromosome = new int[chromosomeLength];
		for (int gene = 0; gene < chromosomeLength; gene++) {
                   this.setGene(gene, (int)Math.round(Math.random()));
			
		}
                

	}
        public double getFitness(){
        return this.fitness;
        }
        public  void setFitness(double fit){this.fitness=fit;}

	public int[] getChromosome() {
		return this.chromosome;
	}

	public int getChromosomeLength() {
		return this.chromosome.length;
	}

	
	public void setGene(int id, int gene) {
		this.chromosome[id] = gene;
	}

	
	public int getGene(int id) {
		return this.chromosome[id];
	}

	
	
   @Override
        public String toString() {
		String s = "";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
			s += this.chromosome[gene];
		}
		return s;
	}
}