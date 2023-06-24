package pjatk.jaz25670nbp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz25670nbp.Model.Results;
import pjatk.jaz25670nbp.Model.Root;
import pjatk.jaz25670nbp.Repository.NbpRepository;
import java.time.LocalDateTime;

@Service
public class NbpService
{
    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository)
    {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public Double getAvgRate(String currency, String start_date, String end_date)
    {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + start_date +"/" + end_date;
        Root root = restTemplate.getForObject(url, Root.class);
        Double average = root.getRates().stream().mapToDouble(x->x.getMid()).average().orElse(0.0);
        Results results = new Results(root.getCurrency(), start_date, end_date, average, LocalDateTime.now());
        nbpRepository.save(results);
        return average;
    }
}
