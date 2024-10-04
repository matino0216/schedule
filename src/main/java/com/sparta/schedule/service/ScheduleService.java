package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        //RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        //DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        //Entity -> ResponseDto
        return new ScheduleResponseDto(saveSchedule);
    }

    //전체 일정 조회
    public List<Schedule> getAllSchedules (String author, String updatedAt) {
        return scheduleRepository.findAll(author, updatedAt);
    }

    //선택 일정 조회
    public ScheduleResponseDto getScheduleById(Long id) {
        // ID로 조회
        Optional <Schedule> optionalSchedule = scheduleRepository.findById(id);

        if(optionalSchedule.isEmpty()) {
            throw new IllegalArgumentException("입력하신 아이디의 일정이 존재하지 않습니다.");
        }

        Schedule schedule = optionalSchedule.get();
        return new ScheduleResponseDto(schedule);
    }

    // 선택 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto, String password) {
        // ID로 조회
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (optionalSchedule.isEmpty()) {
            throw new IllegalArgumentException("입력하신 아이디의 일정이 존재하지 않습니다.");
        }

        // 일정 수정
        Schedule schedule = optionalSchedule.get();

        // 비밀번호 확인
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

        // 할일과 작성자명만 수정
        schedule.setTitle(requestDto.getTitle());
        schedule.setWriter(requestDto.getWriter());

        // 수정일 갱신
        schedule.setUpdatedAt(java.time.LocalDateTime.now());

        // 저장
        Schedule updatedSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        return new ScheduleResponseDto(updatedSchedule);
    }

    //선택 일정 삭제
    public void deleteSchedule(Long id, String password) {
        // ID로 조회
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (optionalSchedule.isEmpty()) {
            throw new IllegalArgumentException("입력하신 아이디의 일정이 존재하지 않습니다.");
        }

        // 삭제
        Schedule schedule = optionalSchedule.get();

        // 비밀번호 확인
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

        // 일정 삭제
        scheduleRepository.delete(schedule);
    }

}