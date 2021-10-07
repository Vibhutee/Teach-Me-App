package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Enum.Option;
import com.teach.me.app.Exception.ResponseNotFoundException;
import com.teach.me.app.Model.Response;
import com.teach.me.app.Repository.ResponseRepository;
import com.teach.me.app.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;
    /**
     * @param response
     */
    @Override
    public Response insertResponse(Response response) {
        return responseRepository.save(response);
    }

    /**
     * @return
     */
    @Override
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    /**
     * @param responseId
     * @return
     */
    @Override
    public Response getResponseById(int responseId) throws ResponseNotFoundException {
        return responseRepository.findById(responseId).orElseThrow(ResponseNotFoundException::new);
    }

    /**
     * @param testId
     * @param userId
     * @return
     */
    @Override
    public List<Response> getReponseByTestIdAndUserId(int testId, int userId) {
        return responseRepository.getByUserUserIdAndTestTestId(userId, testId);
    }

    /**
     * @param userId
     * @param questId
     * @return
     */
    @Override
    public boolean isQuestionAttempted(int userId, int questId) {
        Optional<Response> response = responseRepository.getByUserUserIdAndQuestionQuestionId(userId, questId);
        return response.isPresent();
    }

    /**
     * @param userId
     * @param questId
     * @return
     */
    @Override
    public Response getResponseByUserAndQuest(int userId, int questId) throws ResponseNotFoundException {
        return responseRepository.getByUserUserIdAndQuestionQuestionId(userId, questId).orElseThrow(ResponseNotFoundException::new);
    }

    /**
     * @param userId
     * @param questId
     * @param answer
     */
    @Override
    public void submitResponse(int userId, int questId, String answer) throws ResponseNotFoundException {
        Response response = getResponseByUserAndQuest(userId,questId);
        response.setCorrectness(response.getQuestion().getAnswer().getIndex() == Option.valueOf(answer.toUpperCase()).getIndex());
        response.setStatus("COMPLETED");
        response.setResponse(Option.valueOf(answer.toUpperCase()));
        responseRepository.save(response);
    }
}
