package TP_03;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author IlyesMax
 */
public class Population {
    
private Individual population[];

	
	public Population(int populationSize) {
		// Initialiser la  population
		this.population = new Individual[populationSize];
	}

	public Population(int populationSize, int chromosomeLength) {
		// Initialiser la population comme un tableau d'individus
		this.population = new Individual[populationSize];

		// Creer les individus 
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			
			Individual individual = new Individual(chromosomeLength);
			//ajouter l'individu a la population
			this.population[individualCount] = individual;
		}
	}

	
	public Individual[] getIndividuals() {
		return this.population;
	}

	public int size() {
		return this.population.length;
	}

	
	public Individual setIndividual(int id, Individual individual) {
		return population[id] = individual;
	}

	
	public Individual getIndividual(int id) {
		return population[id];
	}
@Override
        public String toString(){
            String s = "";
		for (int popsize = 0; popsize < this.size(); popsize++) {
			s += population[popsize];
		}
		return s;
}
	
	public Individual getFittest(int offset) {
		// Order population by fitness
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});

		// Return the fittest individual
		return this.population[offset];
	}

	
	
}