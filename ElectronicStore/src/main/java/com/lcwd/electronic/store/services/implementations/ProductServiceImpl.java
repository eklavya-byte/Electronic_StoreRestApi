package com.lcwd.electronic.store.services.implementations;

import com.lcwd.electronic.store.dtos.PagebleResponse;
import com.lcwd.electronic.store.dtos.ProductDto;
import com.lcwd.electronic.store.entities.Category;
import com.lcwd.electronic.store.entities.Product;
import com.lcwd.electronic.store.exceptions.ResourceNotFoundException;
import com.lcwd.electronic.store.helper.Helper;
import com.lcwd.electronic.store.repositories.CategoryRepository;
import com.lcwd.electronic.store.repositories.ProductRepository;
import com.lcwd.electronic.store.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private  CategoryRepository categoryRepository;

    @Value("${product.image.path}")
    private String imagePath;


    @Override
    public ProductDto create(ProductDto productDto) {
        //converting productDto to product
        Product product =mapper.map(productDto, Product.class);
        // product id
        String productId = UUID.randomUUID().toString();
        product.setProductId(productId);
        // added date
        product.setAddedDate(new Date());
        Product saveProduct = productRepository.save(product);
        //converting and returning product to productDto
        return mapper.map(saveProduct,ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto, String productId) {
        // fetch the product of given id
        Product product=productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product not fount on given ID"));
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.isLive());
        product.setStock(productDto.isStock());
        product.setProductImageName(productDto.getProductImageName());
        //save the entity
        Product saveProduct = productRepository.save(product);
        return mapper.map(saveProduct,productDto.getClass());
    }

    @Override
    public void delete(String productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given Id !!"));

        String fullPath = imagePath + product.getProductImageName();

        try {
            Path path = Paths.get(fullPath);
            Files.delete(path);
        } catch (NoSuchFileException ex) {

            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        productRepository.delete(product);

    }

    @Override
    public ProductDto get(String productId) {
        Product product=productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product not fount on given ID"));
        return mapper.map(product,ProductDto.class);
    }

    @Override
    public PagebleResponse<ProductDto> getAll(int pageNumber , int pageSize ,String sortBy,String sortDir ) {
        //sort from data.domain
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> page = productRepository.findAll(pageable);
        return Helper.getPagebleResponse(page,ProductDto.class);
    }

    @Override
    public PagebleResponse<ProductDto> getAllLive(int pageNumber , int pageSize ,String sortBy,String sortDir ) {
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> page = productRepository.findByLiveTrue(pageable);
        return Helper.getPagebleResponse(page,ProductDto.class);
    }

    @Override
    public PagebleResponse<ProductDto> searchByTitle(String subtitle,int pageNumber , int pageSize ,String sortBy,String sortDir ) {
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> page = productRepository.findByTitleContaining(subtitle,pageable);
        return Helper.getPagebleResponse(page,ProductDto.class);
    }

    @Override
    public ProductDto createWithCategory(ProductDto productDto, String categoryId) {

        //fetch the category
        Category category=categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category not found with given id "));
        Product product =mapper.map(productDto, Product.class);
        String productId = UUID.randomUUID().toString();
        product.setProductId(productId);
        product.setAddedDate(new Date());
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        return mapper.map(saveProduct,ProductDto.class);
    }

    @Override
    public ProductDto updateCategory(String productId, String categoryId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product not found with given id "));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category not found with given id"));
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        return mapper.map(saveProduct,ProductDto.class);
    }

    @Override
    public PagebleResponse<ProductDto> getAllOfCategory(String categoryId,int pageNumber,int pageSize,String sortBy,String sortDir) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category not found with given id"));
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable =PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> page = productRepository.findByCategory(category,pageable);
        return Helper.getPagebleResponse(page,ProductDto.class);
    }
}
