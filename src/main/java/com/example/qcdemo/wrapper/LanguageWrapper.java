package com.example.qcdemo.wrapper;

import com.example.qcdemo.dto.LanguageDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LanguageWrapper {
    List<LanguageDTO> languages;
}
