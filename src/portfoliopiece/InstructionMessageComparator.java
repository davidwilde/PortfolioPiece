
package portfoliopiece;

import java.util.Comparator;

/**
 *
 * @author dwilde
 */
public class InstructionMessageComparator implements Comparator<InstructionMessage> {

  public InstructionMessageComparator() {
  }
  
  @Override
  public int compare(InstructionMessage x, InstructionMessage y)
  {
    if (x.getPriority().ordinal() < y.getPriority().ordinal())
    {
      return -1;
    }
    if (x.getPriority().ordinal() > y.getPriority().ordinal())
    {
      return 1;
    }
    return 0;
  }
  
}
