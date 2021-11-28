package com.example.nanumoa.controller;

import com.example.nanumoa.entity.Board;
import com.example.nanumoa.repository.BoardRepository;
import com.example.nanumoa.service.BoardService;
import com.example.nanumoa.validator.BoardValidator;
import com.ibm.dtfj.corereaders.PageCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {


    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm(Model model, @RequestParam(required = false) Long id) {
        if(id == null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro( Board board, Model model) throws Exception{
        boardService.write(board);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }
    @GetMapping("/board/list")
    public String boardList(Model model, Pageable pageable) {

        Page<Board> list = boardRepository.findAll(pageable);

        int startPage = Math.max(0, list.getPageable().getPageNumber() -4);
        int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber() +4);

        model.addAttribute("list", list);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardlist";
    }


//    @GetMapping("/board/list")
//    public String boardList(Model model,
//                            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
//                            String searchKeyword) {
//
//        Page<Board> list = null;
//
//        if(searchKeyword == null) {
//            list = boardService.boardList(pageable);
//        }else {
//            list = boardService.boardSearchList(searchKeyword, pageable);
//        }
//
//        int nowPage = list.getPageable().getPageNumber() + 1;
//        int startPage = Math.max(nowPage - 4, 1);
//        int endPage = Math.min(nowPage + 5, list.getTotalPages());
//
//        model.addAttribute("list", list);
//        model.addAttribute("nowPage", nowPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
//
//        return "boardlist";
//    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Long id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Long id,
                              Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Board board, MultipartFile file) throws Exception{

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";

    }

}