package Upp1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    public int getAmountOfQuestionsInDatabase() {
        return (int) questions.stream().count();

    }

    public int getAmountOfQuestionsForACertainCategory(Category category) {
        return (int) questions.stream()
                .filter(s -> s.category.equals(category)).count();

    }

    public List<String> getListOfAllQuestions() {
        return questions.stream()
                .map(s -> s.question)
                .toList();
    }

    public List<String> getAllQuestionStringsBelongingACategory(Category category) {
        return questions.stream()
                .filter(s -> s.category.equals(category))
                .map(z -> z.question)
                .toList();
    }

    public List<String> getAllAnswerOptionsDistinct() {
        return questions.stream()
                .flatMap(s -> s.answers.stream())
                .distinct()
                .toList();
    }

    public boolean isThisAnAnswerOption(String answerCandidate) {
        return questions.stream()
                .anyMatch(s -> s.answers.stream()
                        .anyMatch(z -> z.equals(answerCandidate)));
    }

    public int getAnswerCandidateFrequency(String answerCandidate) {
        return (int) questions.stream()
                .flatMap(s -> s.answers.stream())
                .filter(a -> a.equalsIgnoreCase(answerCandidate))
                .count();

    }

    public Map<Category, List<String>> getQuestionGroupedByCategory() {
        Map<Category, List<String>> map = questions.stream()
                .collect(groupingBy(Question::getCategory, Collectors.mapping(Question::getQuestionString, Collectors.toList())));
        return map;
    }

    public String getLongestLettercountAnwerInAGivenCategory(Category c) {

        return questions.stream()
                .filter(s->s.category.equals(c))
                .flatMap(s->s.answers.stream())
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
    }



    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();
    }

}