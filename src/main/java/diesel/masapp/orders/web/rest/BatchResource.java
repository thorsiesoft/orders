package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.persistence.Batch;
import diesel.masapp.orders.persistence.repository.BatchRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/batch", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "Batch of inventory items", description = "Create, Update and Delete batches of inventory items")
public class BatchResource {

    private BatchRepository batchRepository;

    @Autowired
    public BatchResource(final BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @GetMapping(path = "/")
    @ApiOperation("A service to get all the batches")
    public List<Batch> getAll() {
        return batchRepository.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to add a batch")
    public void addBatch(@RequestBody final Batch batch) {
        batchRepository.save(batch);
    }
}
