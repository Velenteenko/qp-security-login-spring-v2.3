package ua.com.vza.work.doc.kay.quality.controllers;

//import jdk.nashorn.internal.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.vza.work.doc.kay.quality.crud.*;
import ua.com.vza.work.doc.kay.quality.entity.*;
import ua.vza.vde.qp.dao.IUserDAO;
import ua.vza.vde.qp.impl.UserImplDAO;
import ua.vza.vde.qp.obj.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by kycenko on 16.06.15.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Path("service")
@RequestScoped
public class ServiceController {

    @Inject private SprProductNameCrud spnc;
    @Inject private SprProductTypeCrud sptc;
    @Inject private SprMagazineCrud mc;
    @Inject private SprStandartTypeCrud sstc;
    @Inject private SprStandartNameCrud ssc;
    @Inject private SprConsumerCrud scc;
    @Inject private SprMeasureCrud smc;
    @Inject private SprLocationCrud slc;
    @Inject private ProductCrud pc;
    @Inject private ProductIncomeCrud pic;

//    @Autowired
//    private IUserDAO userDAO;

//    @Path("getFio")
//    @GET
//    @Produces("application/json")
//    public JsonObject getUserFioFromLoginRequersParam(@QueryParam(value = "login") String userLogin){
//        UserImplDAO dao = new UserImplDAO();
//        User user = dao.getUserFioByLogin(userLogin);
//
//        return Json.createObjectBuilder().add("fio", user.getFio()).build();
//    }

    @Path("all_product_name")
    @GET
    @Produces("application/json")
    public JsonArray getAllProductName(@QueryParam("page") Integer page) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (SprProductName productName : spnc.getAll(page)) {
            builder.add(Json.createObjectBuilder().add("Name", productName.getName()));
        }
        return builder.build();
    }

    @Path("all_magazine")
    @GET
    @Produces("application/json")
    public JsonArray getAllMagazine() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        int page = 1;
        for (SprMagazine magazine : mc.getAll(page)) {
            builder.add(Json.createObjectBuilder()
                    .add("MagazineId", magazine.getMagazineId())
                    .add("MagazineName", magazine.getName()));
        }
        return builder.build();
    }

    @Path("all_std_type")
    @GET
    @Produces("application/json")
    public JsonArray getAllStdType() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        int page = 1;
        for (SprStandartType stdType : sstc.getAll(page)) {
            builder.add(Json.createObjectBuilder()
                    .add("stdId", stdType.getSprStdTypeId())
                    .add("stdName", stdType.getName()));
        }
        return builder.build();
    }

    @Path("all_measure")
    @GET
    @Produces("application/json")
    public JsonArray getAllMeasure() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        int page = 1;
        for (SprMeasure measure : smc.getAll(page)) {
            builder.add(Json.createObjectBuilder()
                    .add("MeasureId", measure.getMeasureId())
                    .add("MeasureName", measure.getName()));
        }
        return builder.build();
    }

    @Path("location")
    @GET
    @Produces("application/json")
    public JsonArray getLocation() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        int page = 1;
        for (SprLocation location : slc.getAll(page)) {
            builder.add(Json.createObjectBuilder()
                    .add("LocationId", location.getLocationId())
                    .add("LocationName", location.getName()));
        }
        return builder.build();
    }

    @Path("product_like_name")
    @GET
    @Produces("application/json")
    public JsonArray getProductLikeName(@QueryParam("name") String name) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (SprProductName productName : spnc.getByLike(name)) {
            builder.add(Json.createObjectBuilder()
                    .add("likeId", productName.getSprNameId())
                    .add("likeName", productName.getName()));
        }
        return builder.build();
    }

    @Path("product_like_type")
    @GET
    @Produces("application/json")
    public JsonArray getProductLikeType(@QueryParam("name") String name) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (SprProductType productType : sptc.getByLike(name)) {
            builder.add(Json.createObjectBuilder()
                    .add("likeId", productType.getSprTypeId())
                    .add("likeName", productType.getName()));
        }
        return builder.build();
    }

    @Path("standart_like")
    @GET
    @Produces("application/json")
    public JsonArray getStandartLike(@QueryParam("name") String name) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (SprStandartName productType : ssc.getByLike(name)) {
            builder.add(Json.createObjectBuilder()
                    .add("likeId", productType.getSprStdNameId())
                    .add("likeName", productType.getName()));
        }
        return builder.build();
    }

    @Path("consumer_like_name")
    @GET
    @Produces("application/json")
    public JsonArray getConsumerLikeName(@QueryParam("name") String name) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (SprConsumer consumer : scc.getByLike(name)) {
            builder.add(Json.createObjectBuilder()
                    .add("likeId", consumer.getConsumerId())
                    .add("likeName", consumer.getName()));
        }
        return builder.build();
    }

    @Path("create_product")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void setProduct(JsonObject content) throws ParseException {
        Product product = new Product();
        ProductIncome productIncome = new ProductIncome();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        product.setNameId(Integer.valueOf(content.getString("idProdName")));
        product.setStdNameId(Integer.valueOf(content.getString("nameStandartProdName")));
        product.setTypeId(Integer.valueOf(content.getString("idProdType")));
        product.setStdTypeId(Integer.valueOf(content.getString("nameStandartProdType")));
        product.setWaranty((int) dateFormat.parse(content.getString("waranty")).getTime());
        product.setProduceDate((int) dateFormat.parse(content.getString("produceDate")).getTime());
        product.setLot(content.getString("lot"));
        product.setConsumerId(Integer.valueOf(content.getString("consumerId")));
        product.setNumberDoc(content.getString("numberDoc"));

        productIncome.setMagazineId(Integer.valueOf(content.getString("idMagazine")));
        productIncome.setDatePresenter((int) dateFormat.parse(content.getString("datePresenter")).getTime());
        productIncome.setCountProduct(Integer.valueOf(content.getString("countProduct")));
        productIncome.setMeasureId(Integer.valueOf(content.getString("measureId")));
        productIncome.setLocationId(Integer.valueOf(content.getString("locationId")));
        productIncome.setFioPresenter(content.getString("fioPresenter"));
        productIncome.setFioLastModify(content.getString("fioLastModify"));
        productIncome.setDateLastModify((int) dateFormat.parse(content.getString("dateLastModify")).getTime());
        productIncome.setFioControler(content.getString("fioControler"));
        productIncome.setArrangements(content.getString("arrangements"));
        productIncome.setNote(content.getString("note"));
        productIncome.setProductId(pc.create(product).getId());

        pic.create(productIncome);
    }

}
