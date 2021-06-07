import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.BoundStatementBuilder;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;
import com.datastax.oss.driver.internal.core.util.concurrent.BlockingOperation;
import com.datastax.oss.driver.internal.core.util.concurrent.CompletableFutures;
import com.datastax.oss.driver.internal.mapper.DaoBase;
import com.datastax.oss.driver.internal.querybuilder.update.DefaultUpdate;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.lang.Throwable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import models.Offer;
import models.OfferHelper__MapperGenerated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class OfferDaoImpl__MapperGenerated extends DaoBase implements OfferDao {
  private static final Logger LOG = LoggerFactory.getLogger(OfferDaoImpl__MapperGenerated.class);

  private final OfferHelper__MapperGenerated offerHelper;

  private final PreparedStatement saveStatement;

  private final PreparedStatement getByIdStatement;

  private final PreparedStatement getByIdOfferStatement;

  private final PreparedStatement getByRatingStatement;

  private final PreparedStatement updateByRatingStatement;

  private final PreparedStatement deleteStatement;

  private final PreparedStatement getAllStatement;

  private OfferDaoImpl__MapperGenerated(MapperContext context,
      OfferHelper__MapperGenerated offerHelper, PreparedStatement saveStatement,
      PreparedStatement getByIdStatement, PreparedStatement getByIdOfferStatement,
      PreparedStatement getByRatingStatement, PreparedStatement updateByRatingStatement,
      PreparedStatement deleteStatement, PreparedStatement getAllStatement) {
    super(context);
    this.offerHelper = offerHelper;
    this.saveStatement = saveStatement;
    this.getByIdStatement = getByIdStatement;
    this.getByIdOfferStatement = getByIdOfferStatement;
    this.getByRatingStatement = getByRatingStatement;
    this.updateByRatingStatement = updateByRatingStatement;
    this.deleteStatement = deleteStatement;
    this.getAllStatement = getAllStatement;
  }

  @Override
  public Offer save(Offer offer) {
    BoundStatementBuilder boundStatementBuilder = saveStatement.boundStatementBuilder();
    offerHelper.set(offer, boundStatementBuilder, NullSavingStrategy.DO_NOT_SET);

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToSingleEntity(boundStatement, offerHelper);
  }

  @Override
  public Optional<Offer> getById(int id) {
    BoundStatementBuilder boundStatementBuilder = getByIdStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.setInt("id", id);

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToOptionalEntity(boundStatement, offerHelper);
  }

  @Override
  public Offer getByIdOffer(int id) {
    BoundStatementBuilder boundStatementBuilder = getByIdOfferStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.setInt("id", id);

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToSingleEntity(boundStatement, offerHelper);
  }

  @Override
  public Offer getByRating(int rating) {
    BoundStatementBuilder boundStatementBuilder = getByRatingStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.setInt("id", rating);

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToSingleEntity(boundStatement, offerHelper);
  }

  @Override
  public void updateByRating(Offer offer, int id, int rating) {
    BoundStatementBuilder boundStatementBuilder = updateByRatingStatement.boundStatementBuilder();
    offerHelper.set(offer, boundStatementBuilder, NullSavingStrategy.DO_NOT_SET);

    boundStatementBuilder = boundStatementBuilder.setInt("id", id);

    boundStatementBuilder = boundStatementBuilder.setInt("rating", rating);

    BoundStatement boundStatement = boundStatementBuilder.build();
    execute(boundStatement);
  }

  @Override
  public void delete(Offer offer) {
    BoundStatementBuilder boundStatementBuilder = deleteStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.setInt("id", offer.getId());

    BoundStatement boundStatement = boundStatementBuilder.build();
    execute(boundStatement);
  }

  @Override
  public PagingIterable<Offer> getAll() {
    BoundStatementBuilder boundStatementBuilder = getAllStatement.boundStatementBuilder();

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToEntityIterable(boundStatement, offerHelper);
  }

  public static CompletableFuture<OfferDao> initAsync(MapperContext context) {
    LOG.debug("[{}] Initializing new instance for keyspace = {} and table = {}",
        context.getSession().getName(),
        context.getKeyspaceId(),
        context.getTableId());
    throwIfProtocolVersionV3(context);
    try {
      // Initialize all entity helpers
      OfferHelper__MapperGenerated offerHelper = new OfferHelper__MapperGenerated(context);
      if ((Boolean)context.getCustomState().get("datastax.mapper.schemaValidationEnabled")) {
        offerHelper.validateEntityFields();
      }
      List<CompletionStage<PreparedStatement>> prepareStages = new ArrayList<>();
      // Prepare the statement for `save(models.Offer)`:
      SimpleStatement saveStatement_simple = offerHelper.insert().build();
      LOG.debug("[{}] Preparing query `{}` for method save(models.Offer)",
          context.getSession().getName(),
          saveStatement_simple.getQuery());
      CompletionStage<PreparedStatement> saveStatement = prepare(saveStatement_simple, context);
      prepareStages.add(saveStatement);
      // Prepare the statement for `getById(int)`:
      SimpleStatement getByIdStatement_simple = offerHelper.selectByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method getById(int)",
          context.getSession().getName(),
          getByIdStatement_simple.getQuery());
      CompletionStage<PreparedStatement> getByIdStatement = prepare(getByIdStatement_simple, context);
      prepareStages.add(getByIdStatement);
      // Prepare the statement for `getByIdOffer(int)`:
      SimpleStatement getByIdOfferStatement_simple = offerHelper.selectByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method getByIdOffer(int)",
          context.getSession().getName(),
          getByIdOfferStatement_simple.getQuery());
      CompletionStage<PreparedStatement> getByIdOfferStatement = prepare(getByIdOfferStatement_simple, context);
      prepareStages.add(getByIdOfferStatement);
      // Prepare the statement for `getByRating(int)`:
      SimpleStatement getByRatingStatement_simple = offerHelper.selectByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method getByRating(int)",
          context.getSession().getName(),
          getByRatingStatement_simple.getQuery());
      CompletionStage<PreparedStatement> getByRatingStatement = prepare(getByRatingStatement_simple, context);
      prepareStages.add(getByRatingStatement);
      // Prepare the statement for `updateByRating(models.Offer,int,int)`:
      SimpleStatement updateByRatingStatement_simple = SimpleStatement.newInstance(((DefaultUpdate)offerHelper.updateByPrimaryKey()).asCql());
      LOG.debug("[{}] Preparing query `{}` for method updateByRating(models.Offer,int,int)",
          context.getSession().getName(),
          updateByRatingStatement_simple.getQuery());
      CompletionStage<PreparedStatement> updateByRatingStatement = prepare(updateByRatingStatement_simple, context);
      prepareStages.add(updateByRatingStatement);
      // Prepare the statement for `delete(models.Offer)`:
      SimpleStatement deleteStatement_simple = offerHelper.deleteByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method delete(models.Offer)",
          context.getSession().getName(),
          deleteStatement_simple.getQuery());
      CompletionStage<PreparedStatement> deleteStatement = prepare(deleteStatement_simple, context);
      prepareStages.add(deleteStatement);
      // Prepare the statement for `getAll()`:
      SimpleStatement getAllStatement_simple = offerHelper.selectByPrimaryKeyParts(0).build();
      LOG.debug("[{}] Preparing query `{}` for method getAll()",
          context.getSession().getName(),
          getAllStatement_simple.getQuery());
      CompletionStage<PreparedStatement> getAllStatement = prepare(getAllStatement_simple, context);
      prepareStages.add(getAllStatement);
      // Initialize all method invokers
      // Build the DAO when all statements are prepared
      return CompletableFutures.allSuccessful(prepareStages)
          .thenApply(v -> (OfferDao) new OfferDaoImpl__MapperGenerated(context,
              offerHelper,
              CompletableFutures.getCompleted(saveStatement),
              CompletableFutures.getCompleted(getByIdStatement),
              CompletableFutures.getCompleted(getByIdOfferStatement),
              CompletableFutures.getCompleted(getByRatingStatement),
              CompletableFutures.getCompleted(updateByRatingStatement),
              CompletableFutures.getCompleted(deleteStatement),
              CompletableFutures.getCompleted(getAllStatement)))
          .toCompletableFuture();
    } catch (Throwable t) {
      return CompletableFutures.failedFuture(t);
    }
  }

  public static OfferDao init(MapperContext context) {
    BlockingOperation.checkNotDriverThread();
    return CompletableFutures.getUninterruptibly(initAsync(context));
  }
}
