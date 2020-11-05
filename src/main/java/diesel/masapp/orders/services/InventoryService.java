package diesel.masapp.orders.services;

import diesel.masapp.orders.domain.InventoryForPandas;
import diesel.masapp.orders.domain.InventoryStore;
import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import diesel.masapp.orders.domain.SubmittedInventory;
import diesel.masapp.orders.persistence.Batch;
import diesel.masapp.orders.persistence.Inventory;
import diesel.masapp.orders.persistence.InventoryItem;
import diesel.masapp.orders.persistence.repository.BatchRepository;
import diesel.masapp.orders.persistence.repository.InventoryItemRepository;
import diesel.masapp.orders.persistence.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;
    private BatchRepository batchRepository;
    private InventoryItemRepository inventoryItemRepository;

    public InventoryService(final InventoryRepository inventoryRepository, final BatchRepository batchRepository, final InventoryItemRepository inventoryItemRepository) {
        this.inventoryRepository = inventoryRepository;
        this.batchRepository = batchRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public void addToInventory(final SubmittedInventory submittedInventory) {
        LocalDate batchDate = submittedInventory.getBatchDate();
        int houseNumber = submittedInventory.getHouseNumber();
        Optional<Batch> batchOptional = batchRepository.findByBatchDateAndHouseNumber(batchDate, houseNumber);
        if (batchOptional.isPresent()) {
            Batch batch = batchOptional.get();
            InventoryItem inventoryItem;
            Optional<InventoryItem> inventoryItemOptional = inventoryItemRepository.findByClassificationAndProductAndSizeAndDebonedAndSkinned(ItemClassification.valueOf(submittedInventory.getItemClassification()),
                    Product.fromString(submittedInventory.getProductType()), ItemSize.fromString(submittedInventory.getSize()),
                    submittedInventory.isDeboned(), submittedInventory.isSkinned());
            if (inventoryItemOptional.isPresent()) {
                inventoryItem = inventoryItemOptional.get();
            } else {
                inventoryItem = new InventoryItem(ItemClassification.valueOf(submittedInventory.getItemClassification()),
                        Product.fromString(submittedInventory.getProductType()), ItemSize.fromString(submittedInventory.getSize()),
                        submittedInventory.isDeboned(), submittedInventory.isSkinned());
            }

            InventoryItem savedInventoryItem = inventoryItemRepository.save(inventoryItem);
            Inventory inventory;
            if (submittedInventory.getStore() != null) {
                InventoryStore store = InventoryStore.valueOf(submittedInventory.getStore());
                inventory = new Inventory(batch, savedInventoryItem, BigDecimal.valueOf(submittedInventory.getPrice()), BigDecimal.ZERO, submittedInventory.getQuantity(), store);
            } else {
                inventory = new Inventory(batch, savedInventoryItem, BigDecimal.valueOf(submittedInventory.getPrice()), BigDecimal.ZERO, submittedInventory.getQuantity());
            }

            inventoryRepository.save(inventory);
        }
    }

    public List<InventoryForPandas> getInventoryForPandas() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(inventory -> {
            InventoryForPandas inventoryForPandas = new InventoryForPandas();
            inventoryForPandas.setBatchDate(inventory.getBatch().getBatchDate());
            inventoryForPandas.setClassification(inventory.getItem().getClassification());
            inventoryForPandas.setProduct(inventory.getItem().getProduct());
            inventoryForPandas.setSize(inventory.getItem().getSize());
            inventoryForPandas.setQuantity(inventory.getQuantity());
            inventoryForPandas.setStore(inventory.getStore());
            return inventoryForPandas;
        }).collect(Collectors.toList());
    }
}
