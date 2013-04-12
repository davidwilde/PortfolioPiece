
package portfoliopiece;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dwilde
 */
public class InstructionQueue  {

  PriorityQueue<InstructionMessage> queue;

  public InstructionQueue() {
    Comparator<InstructionMessage> comparator = new InstructionMessageComparator();
    queue = new PriorityQueue(10, comparator);
  }

  public int numberOfInstructionMessages() {
    return queue.size();
  }

  public void placeInstructionMessageOntoQueue(InstructionMessage instructionMessage) throws InvalidExceptionMessage {
    if (!instructionMessage.isValid()) {
      throw new InvalidExceptionMessage();
    }
    else {      
      queue.add(instructionMessage);
    }
  }
  
  public void removeInstructionFromTheQueue(InstructionMessage instructionMessage) {
    queue.remove(instructionMessage);
  }
  
  public boolean isQueueEmpty() {
    return queue.isEmpty(); 
  }

  InstructionMessage retrieveInstructionMessageAtFrontOfQueue() {
    return queue.poll();
  }
}
