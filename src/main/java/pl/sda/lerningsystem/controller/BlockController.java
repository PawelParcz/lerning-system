package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.lerningsystem.entity.Block;
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
        return "blockList";
    }
    @GetMapping("/add")
    public String getViewAdd(){
        return "blockForm";
    }
    @PostMapping(value = "/add")
    public String postBlock(@ModelAttribute("block") Block block){
        blockRepository.save(block);
        return "blockResult";

    }
}
