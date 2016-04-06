package test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for model testing
 * 
 * @author Xingjian Zhang
 * @version 3.0.0
 */
@RunWith(Suite.class)
@SuiteClasses({ ModelTestTDMap.class, ModelTestTower.class, ModelTestCritter.class })
public class ModelSuite {

}
