import java.io.File;
import java.util.List;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
//import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
//import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
//import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
//import org.apache.mahout.cf.taste.similarity.UserSimilarity;
 
class RecommenderIntro {
 
 public static void main(String[] args) throws Exception {

 /*different datasets*/
 DataModel model = new FileDataModel(new File("/home/pulkit/Downloads/ydata-ymusic-rating-study-v1_0-train.csv"));
 //DataModel model = new FileDataModel(new File("/home/pulkit/Downloads/ydata-ymovies-user-movie-ratings-train-v1_0.csv"));
 

/*similarity */
//UserSimilarity similarity = new EuclideanDistanceSimilarity(model);
ItemSimilarity similarity = new EuclideanDistanceSimilarity(model);

/*neighbouhood*/
//UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
 
 /*different recommenrders*/
 //Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
 Recommender recommender = new GenericItemBasedRecommender(model, similarity);
 
 List recommendations = recommender.recommend(2, 10);
 
 recommendations.stream().forEach((recommendation) -> {
     System.out.println(" recommendation: " + recommendation);
     });
 }
}

