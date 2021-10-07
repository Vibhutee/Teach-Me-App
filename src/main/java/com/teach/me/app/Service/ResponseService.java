package com.teach.me.app.Service;

import com.teach.me.app.Exception.ResponseNotFoundException;
import com.teach.me.app.Model.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResponseService {
    /**
     *
     * @param response
     */
    public Response insertResponse(Response response);

    /**
     *
     * @return
     */
    public List<Response> getAllResponses();

    /**
     *
     * @param id
     * @return
     */
    public Response getResponseById(int id) throws ResponseNotFoundException;

    /**
     *
     * @param testId
     * @param userId
     * @return
     */
    public List<Response> getReponseByTestIdAndUserId(int testId, int userId);

    /**
     *
     * @param userId
     * @param questId
     * @return
     */
    public boolean isQuestionAttempted(int userId, int questId);

    /**
     *
     * @param userId
     * @param questId
     * @return
     */
    public Response getResponseByUserAndQuest(int userId, int questId) throws ResponseNotFoundException;

    /**
     *
     * @param userId
     * @param questId
     * @param answer
     */
    public void submitResponse(int userId, int questId, String answer) throws ResponseNotFoundException;
}
