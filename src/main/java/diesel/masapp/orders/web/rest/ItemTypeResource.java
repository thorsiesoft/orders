package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.persistence.ItemType;
import diesel.masapp.orders.persistence.repository.ItemTypeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/items", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "Available items for order", description = "Create, Update and Delete available items for order")
public class ItemTypeResource {

    private ItemTypeRepository itemTypeRepository;

    @Autowired
    public ItemTypeResource(final ItemTypeRepository itemTypeRepository) {
        this.itemTypeRepository = itemTypeRepository;
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to create a new item type for order")
    public void createItemType(final ItemType itemType) {
        itemTypeRepository.save(itemType);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation("A service to get an item type that's available for order")
    public ItemType getItemType(@PathVariable final long id) {
        return itemTypeRepository.getOne(id);
    }

    @CrossOrigin
    @GetMapping(path = "/")
    @ApiOperation("A service to get all item types that are available for order and optionally " +
            "filter the results based on parameters provided")
    public List<ItemType> getAllItemTypes(@RequestParam(required = false) final ItemClassification itemClassification) {
        if (itemClassification != null) {
            return itemTypeRepository.findByClassification(itemClassification);
        } else {
            return itemTypeRepository.findAll();
        }
    }
}
