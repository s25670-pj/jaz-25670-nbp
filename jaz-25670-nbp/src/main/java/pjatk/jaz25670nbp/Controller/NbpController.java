package pjatk.jaz25670nbp.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.jaz25670nbp.Service.NbpService;

@RestController
@RequestMapping("/nbp")
public class NbpController
{
    private NbpService nbpService;

    public NbpController(NbpService nbpService)
    {
        this.nbpService = nbpService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Nie znaleziono waluty"),
            @ApiResponse(code = 400, message = "Błąd zapytania"),
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 504, message = "Server nie działa")
    })
    @ApiOperation(value = "Sredni kurs waluty z podanego zakresu daty", notes = "Podaj walutę, datę początkową oraz końcową zakresu")
    @GetMapping("/{currency}/{start_date}/{end_date}")
    public ResponseEntity<Double> getAverageFromSelectedDays(
            @ApiParam(value = "Waluta", example = "CHF")
            @PathVariable String currency,
            @ApiParam(value = "Data początkowa", example = "2023-06-01")
            @PathVariable String start_date,
            @ApiParam(value = "Data końcowa", example = "2023-06-15")
            @PathVariable String end_date)
    {
        return ResponseEntity.ok(nbpService.getAvgRate(currency, start_date, end_date));
    }
}
