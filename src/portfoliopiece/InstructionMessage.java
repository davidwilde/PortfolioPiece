
package portfoliopiece;

/**
 *
 * @author dwilde
 */
public class InstructionMessage {
 
  private int InstructionType;  
  private int ProductCode;
  private int Quantity;
  private int Uom;
  private int TimeStamp;
  private PriorityLevels Priority;


  public InstructionMessage(int instructionType, int productCode, int quantity, int uom, int timestamp) {
    setInstructionType(instructionType);
    setProductCode(productCode);
    setQuantity(quantity);
    setUom(uom);
    setTimeStamp(timestamp);
    setPriority(instructionType);
  }
  
  public enum PriorityLevels {
    HIGH,
    MEDIUM,
    LOW
  }
  
  public PriorityLevels getPriority() {
    return Priority;
  }

  /**
   * Get the value of InstructionType
   *
   * @return the value of InstructionType
   */
  public int getInstructionType() {
    return InstructionType;
  }

  /**
   * Set the value of InstructionType
   *
   * @param InstructionType new value of InstructionType
   */
  private void setInstructionType(int InstructionType) {
    this.InstructionType = InstructionType;
  }
  
  private void setPriority(int InstructionType) {
    if (InstructionType > 90)
    {
      this.Priority = PriorityLevels.LOW;
    }
    else if (InstructionType > 10)
    {
      this.Priority = PriorityLevels.MEDIUM;
    }
    else
    {
      this.Priority = PriorityLevels.HIGH;
    }
  }
  

  /**
   * Get the value of ProductCode
   *
   * @return the value of ProductCode
   */
  public int getProductCode() {
    return ProductCode;
  }

  /**
   * Set the value of ProductCode
   *
   * @param ProductCode new value of ProductCode
   */
  private void setProductCode(int ProductCode) {
    this.ProductCode = ProductCode;
  }

  /**
   * Get the value of Quantity
   *
   * @return the value of Quantity
   */
  public int getQuantity() {
    return ProductCode;
  }

  /**
   * Set the value of Quantity
   *
   * @param Quantity new value of Quantity
   */
  private void setQuantity(int Quantity) {
    this.Quantity = Quantity;
  }  
  
    /**
   * Get the value of Uom
   *
   * @return the value of Uom
   */
  public int getUom() {
    return Uom;
  }

  /**
   * Set the value of Uom
   *
   * @param Uom new value of Uom
   */
  private void setUom(int Uom) {
    this.Uom = Uom;
  }
  
  /**
   * Get the value of TimeStamp
   *
   * @return the value of TimeStamp
   */
  public int getTimeStamp() {
    return TimeStamp;
  }

  /**
   * Set the value of TimeStamp
   *
   * @param TimeStamp new value of TimeStamp
   */
  private void setTimeStamp(int TimeStamp) {
    this.TimeStamp = TimeStamp;
  }  
  
  public boolean isValid() {
    boolean output = true;
    if (InstructionType < 1) {
      output = false;
    }
    if (InstructionType > 99) {
      output = false;
    }
    if (ProductCode < 1) {
      output = false;
    }
    if (Quantity < 1 ) {
      output = false;
    }
    if (Uom < 0) {
      output = false;
    }    
    if (TimeStamp < 1) {
      output = false;
    }
      
    return output;
  }
  
}


