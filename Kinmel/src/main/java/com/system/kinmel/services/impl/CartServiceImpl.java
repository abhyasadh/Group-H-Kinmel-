package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.Sale;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.repo.CartRepo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.repo.SaleRepo;
import com.system.kinmel.repo.UserRepo;
import com.system.kinmel.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.system.kinmel.services.impl.ProductServiceImpl.getImageBase64;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final SaleRepo saleRepo;

    @Override
    public String saveToCart(Integer id, Principal principal) {
        Cart cart = new Cart();
        cart.setUser(userRepo.findByEmail(principal.getName()).orElseThrow());
        cart.setProduct(productRepo.findById(id).orElseThrow());
        cart.setQuantity(1);
        cartRepo.save(cart);

        return "Saved";
    }

    @Override
    public String deleteFromCart(Integer id) {
        cartRepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public String updateQuantity(Cart cart) {
        cartRepo.save(cart);
        return "Updated";
    }

    @Override
    public List<Cart> fetchAll(Integer id) {
        List<Cart> allItems = cartRepo.fetchAll(id).orElseThrow();
        for (Cart cart : allItems){
            cart.setProduct(Product.builder()
                    .id(cart.getProduct().getId())
                    .product_size(cart.getProduct().getProduct_size())
                    .product_quantity(cart.getProduct().getProduct_quantity())
                    .product_category(cart.getProduct().getProduct_category())
                    .product_image(getImageBase64(cart.getProduct().getProduct_image()))
                    .product_color(cart.getProduct().getProduct_color())
                    .product_name(cart.getProduct().getProduct_name())
                    .product_description(cart.getProduct().getProduct_description())
                    .product_price(discountedPrice(cart.getProduct()))
                    .build());
        }
        return allItems;
    }

    public List<Cart> fetchAvailable(Integer id) {
        List<Cart> allItems = cartRepo.fetchAll(id).orElseThrow();
        for (Cart cart : allItems){
            if (cart.getQuantity()<cart.getProduct().getProduct_quantity()) {
                cart.setProduct(Product.builder()
                        .id(cart.getProduct().getId())
                        .product_size(cart.getProduct().getProduct_size())
                        .product_quantity(cart.getProduct().getProduct_quantity())
                        .product_category(cart.getProduct().getProduct_category())
                        .product_image(getImageBase64(cart.getProduct().getProduct_image()))
                        .product_color(cart.getProduct().getProduct_color())
                        .product_name(cart.getProduct().getProduct_name())
                        .product_description(cart.getProduct().getProduct_description())
                        .product_price(discountedPrice(cart.getProduct()))
                        .build());
            } else {
                allItems.remove(cart);
            }
        }
        return allItems;
    }

    public Double discountedPrice(Product product){
        List<Sale> sales = saleRepo.saleProducts();
        for (Sale sale : sales) {
            if (sale.getProduct().getId().equals(product.getId())) {
                return product.getProduct_price() - sale.getDiscountPercent()/100 * product.getProduct_price();
            }
        }
        return product.getProduct_price();
    }

    @Override
    public Cart fetchOne(Integer id) {
        return cartRepo.findById(id).orElseThrow();
    }

    @Override
    public String checkout(Integer id, CartPojo pojo, List<Cart> itemsToPurchase) {
        for (Cart value : itemsToPurchase) {
            Cart cart = new Cart();
            cart.setId(value.getId());
            cart.setUser(value.getUser());
            cart.setProduct(value.getProduct());
            cart.setQuantity(value.getQuantity());
            cart.setBillingAddress(pojo.getBillingAddress());
            cart.setBillingApartment(pojo.getBillingApartment());
            cart.setBillingCompany_name(pojo.getBillingCompany_name());
            cart.setBillingFirstName(pojo.getBillingFirstName());
            cart.setBillingLastName(pojo.getBillingLastName());
            cart.setBillingTown(pojo.getBillingTown());
            cart.setBillingState(pojo.getBillingState());
            cart.setBillingEmail(pojo.getBillingEmail());
            cart.setBillingPhone(pojo.getBillingPhone());
            cart.setBillingPostal(pojo.getBillingPostal());

            if (pojo.getDifferentShipping() == null || !pojo.getDifferentShipping()) {
                cart.setShippingAddress(pojo.getBillingAddress());
                cart.setShippingApartment(pojo.getBillingApartment());
                cart.setShippingCompany_name(pojo.getBillingCompany_name());
                cart.setShippingFirstName(pojo.getBillingFirstName());
                cart.setShippingLastName(pojo.getBillingLastName());
                cart.setShippingTown(pojo.getBillingTown());
                cart.setShippingState(pojo.getBillingState());
                cart.setShippingEmail(pojo.getBillingEmail());
                cart.setShippingPhone(pojo.getBillingPhone());
                cart.setShippingPostal(pojo.getBillingPostal());
            } else {
                cart.setShippingAddress(pojo.getShippingAddress());
                cart.setShippingApartment(pojo.getShippingApartment());
                cart.setShippingCompany_name(pojo.getShippingCompany_name());
                cart.setShippingFirstName(pojo.getShippingFirstName());
                cart.setShippingLastName(pojo.getShippingLastName());
                cart.setShippingTown(pojo.getShippingTown());
                cart.setShippingState(pojo.getShippingState());
                cart.setShippingEmail(pojo.getShippingEmail());
                cart.setShippingPhone(pojo.getShippingPhone());
                cart.setShippingPostal(pojo.getShippingPostal());
            }
            cart.setNotes(pojo.getNotes());
            cart.setStatus("Ordered");

            cartRepo.save(cart);
        }
        return "Saved Purchase";
    }

    @Override
    public String updateProduct(double quantity, Integer id) {
        productRepo.updateQuantity(quantity, id);
        return "Updated Quantity";
    }

    @Override
    public List<Cart> fetchAll() {
        return cartRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public List<Object[]> fetchCustomer() {
        return cartRepo.fetchAllCustomer();
    }

    @Override
    public List<Integer> fetch5weeksales() {
        return cartRepo.fetchlast5weeksales();
    }

    @Override
    public List<Object[]> fetchlastweeksale() {
        return cartRepo.getDailySalesLastWeek();
    }

    @Override
    public List<Object[]> fetchproductlastweeksales() {
        return cartRepo.getProductSalesLastWeek();
    }

    @Override
    public List<Object[]> fetchstatusCount() {
        return cartRepo.getStatusCountLastWeek();
    }
}
