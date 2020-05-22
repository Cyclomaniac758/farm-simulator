package crops;
/**
 * Class Wheat extends Crops
 * @author Michael
 *
 */
public class Wheat extends Crops {
  /**
   * Constructor for the Wheat class
   */
  public Wheat(){
    setCropName("Wheat");
    setBuyPrice(20);
    setSellPrice(25);
    setTotalGrowTime(1);
  }
}