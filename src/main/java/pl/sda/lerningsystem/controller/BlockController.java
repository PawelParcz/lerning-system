package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.lerningsystem.entity.Block;
import pl.sda.lerningsystem.entity.Lecture;
import pl.sda.lerningsystem.repository.BlockRepository;

import java.util.List;

@Controller
@RequestMapping("/block")
public class BlockController {
    private final BlockRepository blockRepository;

    public BlockController(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }
    @GetMapping("/list")
    public String getListBlock(Model model){
        List<Block> blocks=blockRepository.findAll();
        model.addAttribute("block",blocks);
        return "block/blockList";
    }

    @GetMapping("/add")
    public String getViewAdd(){
        return "block/blockForm";
    }
    @PostMapping(value = "/add")
    public String postBlock(@ModelAttribute("block") Block block){
        blockRepository.save(block);
        return "block/blockResult";
    }

    @GetMapping("/{id}/delete")
    public String getForm(@PathVariable("id") Long id, Model model) {
        var block = blockRepository.findById(id).orElseThrow(() -> new RuntimeException("There is NOTHING!"));
        model.addAttribute("block", block);
        return "block/blockDeleteForm";
    }

    @PostMapping("/{id}/delete")
    public String proceedForm(@PathVariable("id") Long id, @ModelAttribute Block deletedBlock) {
        blockRepository.deleteById(id);
        return "block/blockDeleteResult";
    }
}
