package sample;

import TP_03.GeneticAlgorithm;
import TP_03.Population;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project_mssc.TP_01;
import project_mssc.TP_02;
import project_mssc.WolframCA;

public class Controller {
    public Label numberofgen;
    public Label mutationprob;
    public Label crosproba;
    public TextField gennumber;
    public TextField resulat;
    public TextField genesnumber;
    public TextField mutaprob;
    public TextField populationsizee;
    public TextField Craosproba;
    int  generation=0;
    Population ppl;

    public void Tp1(ActionEvent actionEvent) {
        TP_01 tp_01 = new TP_01();
        Stage stage = new Stage();
        tp_01.start(stage);
    }

    public void Tp2(ActionEvent actionEvent) {
        new TP_02(200, 150, 5000);
    }


    public void gen(){
        int genrationnumer = (int) Double.parseDouble(gennumber.getText());
        int populationsize = Integer.parseInt(populationsizee.getText());
        int genesnumbe = Integer.parseInt(genesnumber.getText());
        double mutationprob = Double.parseDouble(mutaprob.getText());
        double corrsprobaa = Double.parseDouble(Craosproba.getText());

        GeneticAlgorithm ga = new GeneticAlgorithm(populationsize,mutationprob, corrsprobaa);

        //Initialize population.
        Population population = ga.initPopulation(genesnumbe);
        ppl = population;

        while (generation<genrationnumer){


            // Apply crossover
            population = ga.crossover(population);

            // Apply mutation
            population = ga.mutation(population);
            generation++;
        }

    }

    public void calculate(ActionEvent actionEvent) {
        gen();
        System.out.println("generation= " + generation + " generations");
        System.out.println("Solution min: " + ppl.getFittest(0).toString());
        resulat.setText(ppl.getFittest(0).toString());

    }

    public void githubb(ActionEvent actionEvent) {
        WolframCA wolframCA = new WolframCA();
        wolframCA.runn();
    }
}
