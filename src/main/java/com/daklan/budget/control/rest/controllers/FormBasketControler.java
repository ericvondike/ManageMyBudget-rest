package com.daklan.budget.control.rest.controllers;


import com.daklan.budget.control.rest.dto.input.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormBasketControler {
    private final Logger LOGGER = LoggerFactory.getLogger(FormBasketControler.class);

    ShoppingListIn shoppingListIn;

    public FormBasketControler(ShoppingListIn shoppingListIn) {
        super();
        this.shoppingListIn = shoppingListIn;
    }

    public ShoppingListIn getShoppingListIn() {
        return shoppingListIn;
    }

    public void setShoppingListIn(ShoppingListIn shoppingListIn) {
        this.shoppingListIn = shoppingListIn;
    }


    @ModelAttribute("allShoppingCenters")
    public List<ShoppingCenter> populateShoppingCenters() {
        return Arrays.asList(ShoppingCenter.ALL);
    }

    @ModelAttribute("allCategories")
    public List<Category> populateCategories() {
        return Arrays.asList(Category.ALL);
    }

    @RequestMapping(value = "/basketform")
    public String showBasketForm(Model model) {

        ShoppingListIn shoppingListIn = new ShoppingListIn();
        this.shoppingListIn = shoppingListIn;
        model.addAttribute("basketForm", shoppingListIn);

        return "basketform";
    }

    @RequestMapping(value="/basketform", params={"addCategory"})
    public String addRow(final ShoppingListIn shoppingListIn, final BindingResult result, final Model model) {
        CategoryIn categoryIn = new CategoryIn();
        shoppingListIn.getCategoryInList().add(categoryIn);
        model.addAttribute("category", categoryIn);
        model.addAttribute("basketForm", shoppingListIn);
        this.shoppingListIn = shoppingListIn;

        return  "basketform";
    }

    @RequestMapping(value = "/basketform", params={"removeCategory"})
    public String removeRow(final ShoppingListIn shoppingListIn, final BindingResult bindingResult,
                            final HttpServletRequest req, final Model model){
        final Integer rowId = Integer.valueOf(req.getParameter("removeCategory"));
        List<CategoryIn> category = shoppingListIn.getCategoryInList();
        category.remove(rowId.intValue());
        model.addAttribute("basketForm", shoppingListIn);
        this.shoppingListIn = shoppingListIn;

        return "basketform";
    }

    @RequestMapping(value = "/basketform", params={"addItem"})
    public String addItem(final ShoppingListIn shoppingListIn,
                          final BindingResult bindingResult,
                          final HttpServletRequest req, final Model model){
        final Integer rowId = Integer.valueOf(req.getParameter("addItem"));
        CategoryIn categoryIn = shoppingListIn.getCategoryInList().get(rowId.intValue());
        categoryIn.getItemsList().add(new ItemIn());
        model.addAttribute("basketForm", shoppingListIn);
        this.shoppingListIn = shoppingListIn;

        return "basketform";
    }


    @RequestMapping(path = "/basketform/{categoryIndex}/{itemIndex}")
    public String removeItem(final ShoppingListIn shoppingListInp,
                             @PathVariable("categoryIndex") String categoryIndex,
                             @PathVariable("itemIndex") String itemIndex,
                             final BindingResult bindingResult,
                             final Model model) throws IOException {
        final Integer catInd = Integer.valueOf(categoryIndex);
        final Integer itemInd = Integer.valueOf(itemIndex);
        ShoppingListIn shoppingListIn = this.shoppingListIn;
        CategoryIn categoryIn = shoppingListIn.getCategoryInList().get(catInd.intValue());
        categoryIn.getItemsList().remove(itemInd.intValue());
        model.addAttribute("basketForm",shoppingListIn);
        this.shoppingListIn = shoppingListIn;

        return "basketform";
    }
}