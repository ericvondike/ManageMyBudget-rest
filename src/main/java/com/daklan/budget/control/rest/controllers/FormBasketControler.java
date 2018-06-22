package com.daklan.budget.control.rest.controllers;


import com.daklan.budget.control.rest.dto.Category;
import com.daklan.budget.control.rest.dto.input.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FormBasketControler {
    private final Logger LOGGER = LoggerFactory.getLogger(FormBasketControler.class);

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
        model.addAttribute("basketForm", shoppingListIn);

        return "basketform";
    }

    @RequestMapping(value="/basketform", params={"addCategory"})
    public String addCategory(final ShoppingListIn shoppingListIn, final BindingResult result, final Model model) {
        CategoryIn categoryIn = new CategoryIn();
        shoppingListIn.getCategoryInList().add(categoryIn);
        model.addAttribute("category", categoryIn);
        model.addAttribute("basketForm", shoppingListIn);

        return  "basketform";
    }

    @RequestMapping(value = "/basketform", params={"removeCategory"})
    public String removeCategory(final ShoppingListIn shoppingListIn, final BindingResult bindingResult,
                            final HttpServletRequest req, final Model model){
        final Integer rowId = Integer.valueOf(req.getParameter("removeCategory"));
        List<CategoryIn> category = shoppingListIn.getCategoryInList();
        category.remove(rowId.intValue());
        model.addAttribute("basketForm", shoppingListIn);

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

        return "basketform";
    }




    @RequestMapping(value = "/basketform", params={"removeItem"})
    public String removeItem(final ShoppingListIn shoppingListIn,
                          final BindingResult bindingResult,
                          final HttpServletRequest req, final Model model){
        final String catItem = req.getParameter("removeItem");
        String strCatIndex = null;
        String strItemIndex = null;
        Pattern pattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher(catItem);
        if(matcher.find()) {
            strCatIndex = catItem.substring(0, matcher.start());
            strItemIndex = catItem.substring(matcher.end());
        }
        if (strCatIndex == null || strItemIndex == null) {
            throw new IllegalArgumentException ("The value of catIndex cannot be null");
        }
        final int catIndex = Integer.parseInt(strCatIndex);
        final int itemIndex = Integer.parseInt(strItemIndex);
        CategoryIn categoryIn = shoppingListIn.getCategoryInList().get(catIndex);
        categoryIn.getItemsList().remove(itemIndex);
        model.addAttribute("basketForm", shoppingListIn);

        return "basketform";
    }
}