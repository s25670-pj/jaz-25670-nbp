package pjatk.jaz25670nbp.Model;

import javax.persistence.*;
import java.util.List;

public class Root
{

    private Long id;
    private String table;
    private String currency;
    private String code;

    @OneToMany
    private List<Rate> rates;

    public Root()
    {
    }

    public Root(Long id, String table, String currency, String code, List<Rate> rates)
    {
        this.id = id;
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public List<Rate> getRates()
    {
        return rates;
    }

    public void setRates(List<Rate> rates)
    {
        this.rates = rates;
    }

}
