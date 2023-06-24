package pjatk.jaz25670nbp.Model;

public class Rate
{
    private Long id;
    private String no; //numer kursu walutowego
    private String effectiveDate;
    private Double mid; //średnia wartość kursu walutowego

    public Double getMid()
    {
        return mid;
    }

    public void setMid(double mid)
    {
        this.mid = mid;
    }

}
