package com.googlecode.caparf.framework.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.googlecode.caparf.framework.base.Algorithm;
import com.googlecode.caparf.framework.base.BaseInput;
import com.googlecode.caparf.framework.base.InputSuite;
import com.googlecode.caparf.framework.base.BaseOutput;
import com.googlecode.caparf.framework.base.BaseOutputVerdict;
import com.googlecode.caparf.framework.base.BaseOutputVerifier;

/**
 * Defines scenario to be executed by caparf.
 *
 * @author denis.nsc@gmail.com (Denis Nazarov)
 */
public class Scenario<I extends BaseInput, O extends BaseOutput, V extends BaseOutputVerdict> {

  private List<Algorithm<I, O>> algorithms;
  private InputSuite<I> inputs;
  private BaseOutputVerifier<I, O, V> verifier;

  /**
   * Creates empty scenario.
   */
  public Scenario() {
    algorithms = new ArrayList<Algorithm<I, O>>();
    inputs = new InputSuite<I>();
    verifier = null;
  }

  /**
   * @return all algorithms in the scenario
   */
  public List<Algorithm<I, O>> getAlgorithms() {
    return algorithms;
  }

  /**
   * @return suite of all inputs in the scenario
   */
  public InputSuite<I> getInputs() {
    return inputs;
  }

  /**
   * @return verifier to be used in the scenario
   */
  public BaseOutputVerifier<I, O, V> getVerifier() {
    return verifier;
  }

  /**
   * Adds single algorithm to the scenario.
   *
   * @param algorithm algorithm to add
   */
  public void addAlgorithm(Algorithm<I, O> algorithm) {
    this.algorithms.add(algorithm);
  }

  /**
   * Adds list of algorithms to the scenario.
   *
   * @param algorithms list of algorithms to add
   */
  public void addAlgorithms(List<? extends Algorithm<I, O>> algorithms) {
    this.algorithms.addAll(algorithms);
  }

  /**
   * Adds all given algorithms to the scenario.
   *
   * @param algorithms algorithms to add
   */
  public <T extends Algorithm<I, O>> void addAlgorithms(T... algorithms) {
    Collections.addAll(this.algorithms, algorithms);
  }

  /**
   * Adds single input to the scenario.
   *
   * @param input input to add
   */
  public void addInput(I input) {
    this.inputs.add(input);
  }

  /**
   * Adds suite of inputs to the scenario.
   *
   * @param suite suite of inputs to add
   */
  public void addInputSuite(InputSuite<? extends I> suite) {
    this.inputs.addAll(suite.getAll());
  }

  /**
   * Adds list of inputs to the scenario.
   *
   * @param inputs list of inputs to add
   */
  public void addInputs(List<? extends I> inputs) {
    this.inputs.addAll(inputs);
  }

  /**
   * Adds all given inputs to the scenario.
   *
   * @param inputs inputs to add
   */
  public <T extends I> void addInputs(T... inputs) {
    this.inputs.addAll(inputs);
  }

  /**
   * Sets verifier to be used in the scenario.
   *
   * @param verifier verifier to be used in the scenario
   */
  public void setVerifier(BaseOutputVerifier<I, O, V> verifier) {
    this.verifier = verifier;
  }
}
