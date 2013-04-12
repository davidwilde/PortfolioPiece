package portfoliopiece;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import portfoliopiece.InstructionMessage;
import portfoliopiece.InstructionQueue;

/**
 *
 * @author dwilde
 */
public class InstructionQueueTests {

  public InstructionQueueTests() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testNumberOfInstructionMessagesInQueueIsZero() {
    // Arrange
    InstructionQueue instructionQueue = new InstructionQueue();
    int expected = 0;
    int actual;

    // Act
    actual = instructionQueue.numberOfInstructionMessages();

    // Assert
    Assert.assertEquals(actual, expected);
    Assert.assertTrue(instructionQueue.isQueueEmpty());
  }

  @Test
  public void testAddingInstructionMessagesIncreasesNumberOfInstructionMessages() throws InvalidExceptionMessage {
    // Arrange
    InstructionQueue instructionQueue = new InstructionQueue();
    int expected = 1;
    InstructionMessage instructionMessage = new InstructionMessage(1, 1, 1, 0, 1);

    // Act
    instructionQueue.placeInstructionMessageOntoQueue(instructionMessage);

    // Assert
    Assert.assertEquals(instructionQueue.numberOfInstructionMessages(), expected);
    Assert.assertFalse(instructionQueue.isQueueEmpty());
  }

  @Test
  public void testRemovingInstructionMessagesDecreasesNumberOfInstructionMessages() throws InvalidExceptionMessage {
    // Arrange
    InstructionQueue instructionQueue = new InstructionQueue();
    int expected = 1;
    InstructionMessage instructionToRemove = new InstructionMessage(2, 2, 2, 0, 2);
    instructionQueue.placeInstructionMessageOntoQueue(new InstructionMessage(1, 1, 1, 0, 1));
    instructionQueue.placeInstructionMessageOntoQueue(instructionToRemove);

    // Act
    instructionQueue.removeInstructionFromTheQueue(instructionToRemove);

    // Assert
    Assert.assertEquals(instructionQueue.numberOfInstructionMessages(), expected);
    Assert.assertFalse(instructionQueue.queue.contains(instructionToRemove));
  }
  
  @Test(expected=InvalidExceptionMessage.class)
  public void testAddingInvalidInstructionMessageThrowsException() throws InvalidExceptionMessage {
    InstructionQueue instructionQueue = new InstructionQueue();
    InstructionMessage invalidInstruction = new InstructionMessage(-1, 1, 1, 0, 101);
    
    instructionQueue.placeInstructionMessageOntoQueue(invalidInstruction);
    
  }

  @Test
  public void testReturnsHighPriorityBeforeMediumAtFrontOfQueue() throws InvalidExceptionMessage {
    // Arrange
    InstructionQueue instructionQueue = new InstructionQueue();
    InstructionMessage mediumInstruction = new InstructionMessage(15, 1, 1, 0, 1);
    InstructionMessage highInstruction = new InstructionMessage(5, 2, 2, 0, 2);
    instructionQueue.placeInstructionMessageOntoQueue(mediumInstruction);
    instructionQueue.placeInstructionMessageOntoQueue(highInstruction);

    // Act
    InstructionMessage actual = instructionQueue.retrieveInstructionMessageAtFrontOfQueue();

    // Assert
    Assert.assertEquals(actual, highInstruction);
  }

  @Test
  public void testReturnsMediumPriorityBeforeLowAtFrontOfQueue() throws InvalidExceptionMessage {
    // Arrange
    InstructionQueue instructionQueue = new InstructionQueue();
    InstructionMessage mediumInstruction = new InstructionMessage(15, 1, 1, 0, 1);
    InstructionMessage lowInstruction = new InstructionMessage(95, 2, 2, 0, 2);
    instructionQueue.placeInstructionMessageOntoQueue(lowInstruction);
    instructionQueue.placeInstructionMessageOntoQueue(mediumInstruction);


    // Act
    InstructionMessage actual = instructionQueue.retrieveInstructionMessageAtFrontOfQueue();

    // Assert
    Assert.assertEquals(actual, mediumInstruction);
  }
}
