package TP_03;
/**
 *
 * @author IlyesMax
 */
public class GeneticAlgorithm {
    private int populationSize;
	private double mutationProba;
        private double crossoverProba;
	

	public GeneticAlgorithm(int populationSize, double mutationProba, double crossoverProba) {
		this.populationSize = populationSize;
		this.mutationProba = mutationProba;
		this.crossoverProba = crossoverProba;
		
	}

           // Initializer la population
	public Population initPopulation(int chromosomeLength) {
		
		Population population = new Population(this.populationSize, chromosomeLength);
		return population;
	}
        
             // Get individual
		public Individual selectParent(Population population) {
		
		int i =(int)Math.random()*20;
		return  population.getIndividual(i);
                
	}
                
                public Population selectPopulation(Population population){
                    Individual individuals[] = population.getIndividuals();
                    
                    Population newPopulation =new Population(population.size()/2);
                    int [] indices=indices = new int[population.size()/2];
                    for(int i=0;i<population.size()/2;i++){
                    indices[i]=(int) (Math.random() * 20);
                    }
                    for(int j=0;j<population.size()/2;j++){
                     newPopulation.setIndividual(j,individuals[indices[j]]);             
                
                    }
                    
    return newPopulation;
                }
                


	public Population crossover(Population population) {
		// Creer une nouvelle population
		Population crosPopulation = new Population(population.size());

		
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex= populationIndex+2) {
			Individual parent1 = population.getIndividual(populationIndex);
// Find parent2
				Individual parent2 = selectParent(population);
			// Apply crossover to this individual?
			if (this.crossoverProba > Math.random()) {
                            //faire le crossover
				// Initialize offspring
				Individual newIndiv1 =parent1;
				Individual newIndiv2 =parent1;
				

				// Loop over genome
                                int posCross=(int) (Math.random() * parent1.getChromosomeLength());
                                
				for (int geneIndex = 0; geneIndex <posCross; geneIndex++) {
			
					newIndiv1.setGene(geneIndex, parent2.getGene(geneIndex));
                                               
					} 
                               for (int geneIndex = posCross+1; geneIndex <parent1.getChromosomeLength(); geneIndex++) {
						
                                                newIndiv2.setGene(geneIndex, parent2.getGene(geneIndex));
					}
				

				// ajouter le nouveau individu a la nouvelle population
				crosPopulation.setIndividual(populationIndex, newIndiv1);
                                crosPopulation.setIndividual(populationIndex+1, newIndiv2);
			} else {
			
                                //Ajouter l'individu a la nouvelle population sans appeler crossover
				crosPopulation.setIndividual(populationIndex, parent1);
                                crosPopulation.setIndividual(populationIndex+1,parent2); 
			}
		}

		return crosPopulation;
	}

	
	public Population mutation(Population population) {
		// Initialize new population
		Population newPopulation = new Population(this.populationSize);

		
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual individual = population.getIndividual(populationIndex);

			// Loop over individual's genes
			for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
				
				
					
					if (this.mutationProba > Math.random()) {
						// Get new gene
						int newGene = 1;
						if (individual.getGene(geneIndex) == 1) {
							newGene = 0;
						}
						// Mutate gene
						individual.setGene(geneIndex, newGene);
					}
				
			}

			// Add individual to population
			newPopulation.setIndividual(populationIndex, individual);
		}

		// Return mutated population
		return newPopulation;
	}
        
      
       public double calculFitness(Individual individual) {

		// Track number of correct genes
		int  nmbrOf1 = 0;

		// Loop over individual's genes
		for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
			// Add one fitness point for each "1" found
			if (individual.getGene(geneIndex) == 1) {
				 nmbrOf1 += 1;
			}
		}
               // Calculate fitness
		double fitness = (double) nmbrOf1 / individual.getChromosomeLength();

		// Store fitness
		individual.setFitness(fitness);

		return fitness;
	}

    
       

        
        
        public static void main(String[] args) {

   int  populationSize = 20;
   int numberOfGenes = 30;
   int GenNumber = 10;
   double mutationProba = 0.001;
   double crossProba= 0.95;

		
		GeneticAlgorithm ga = new GeneticAlgorithm(populationSize,mutationProba, crossProba);
              int  generation=0;
              //Initialize population.
                	Population population = ga.initPopulation(numberOfGenes);
                        
              while (generation<GenNumber){
                
                 
			// Apply crossover
			population = ga.crossover(population);

			// Apply mutation
			population = ga.mutation(population);
			generation++;
              }
              System.out.println("generation= " + generation + " generations");
              System.out.println("Solution min: " + population.getFittest(0).toString());
                
              
    }
        
        
}
    

