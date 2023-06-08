package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;
import com.example.javafxtest.model.entities.Client;
import com.example.javafxtest.model.entities.Os;
import com.example.javafxtest.model.entities.Technician;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.example.javafxtest.model.entities.enums.OsStatus.*;

/**
 * Classe OsDAOImp representa a implementação da interface OsDAO, responsável por gerenciar as ordens de serviço (Os) do sistema.
 */
public class OsDAOImp implements OsDAO {

    public Queue<Os> queue = new LinkedList<>();
    public ArrayList<Os> osCanceledList = new ArrayList<>();
    public ArrayList<Os> osFinishedList = new ArrayList<>();
    File fileQueue = new File(System.getProperty("user.dir") + File.separator + "osQueue.json");
    File fileCanceled = new File(System.getProperty("user.dir") + File.separator + "osCanceled.json");
    File fileFinished = new File(System.getProperty("user.dir") + File.separator + "osFinished.json");

    public OsDAOImp() {
    }

    /**
     * Pega a primeira Os da fila e a define para o técnico.
     *
     * @param technician - Técnico que irá receber a Os.
     */
    public void takeOs(Technician technician) throws IOException { //Pega a primeira Os da fila e a define para o tecnico
        if (technician.getOs() != null) {
            System.out.println("Finalize a Os atual antes de pegar outra");
        } else {
            Path filePath = fileQueue.toPath();
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Reader reader = Files.newBufferedReader(filePath);
            Queue<Os> queueFromJson = readOsQueue();
            Os first = queueFromJson.peek();
            if (first == null) {
                System.out.println("Não há Ordens de serviço na fila");
                return;
            }
            deleteOsInQueue();
            technician.setOs(first);
            first.setStatus(IN_PROGRESS);
            TechnicianDAOImp tec = new TechnicianDAOImp();
            tec.updateTechnicianOs(technician, technician.getOs());
        }
    }

    /**
     * Adiciona uma Os à fila.
     *
     * @param os - Os a ser adicionada.
     */
    public void insertOsInQueue(Os os) throws IOException { //adicionar os a fila
        os.setStatus(IN_PROGRESS);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (fileQueue.getParentFile().exists()){
            Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
            Queue<Os> queueFromJson = readOsQueue();
            queueFromJson.add(os);
            String updateJson = gson.toJson(queueFromJson);
            FileWriter writer = new FileWriter(fileQueue);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else{
            queue.add(os);
            String queueJson = gson.toJson(queue);
            FileWriter writer = new FileWriter(fileQueue);
            writer.write(queueJson);
            writer.flush();
            writer.close();
        }
    }

    /**
     * Cancela uma Os, deixando assim o técnico livre.
     *
     * @param technician Técnico que está com a Os a ser cancelada.
     */
    public void cancelOs(Technician technician) throws IOException { //Cancelar a os, deixando assim o tecnico livre
        TechnicianDAOImp tec = new TechnicianDAOImp();
        technician.getOs().setStatus(CANCELED);
        tec.updateTechnicianOs(technician, technician.getOs());
        technician.setOs(null);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (fileCanceled.getParentFile().exists()){
            Reader reader = Files.newBufferedReader(fileCanceled.toPath());
            ArrayList<Os> osCanceleds = gson.fromJson(reader, new TypeToken<ArrayList<Os>>(){}.getType());
            osCanceleds.add(technician.getOs());
            String updateJson = gson.toJson(osCanceleds);
            FileWriter writer = new FileWriter(fileCanceled);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else{
            osCanceledList.add(technician.getOs());
            String canceledJson = gson.toJson(osCanceledList);
            FileWriter writer = new FileWriter(fileCanceled);
            writer.write(canceledJson);
            writer.flush();
            writer.close();

        }
    }

    /**
     * Finaliza uma Os, adicionando-a à lista de Os finalizadas.
     *
     * @param technician Técnico que está com a Os a ser finalizada.
     */
    public void finishOs(Technician technician) throws IOException {
        technician.getOs().setStatus(FINISH);
        technician.getOs().setEndTime(new Date()); // Adicionar dia de finalização da os
        TechnicianDAOImp tec = new TechnicianDAOImp();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (fileFinished.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("osFinished.json"));
            ArrayList<Os> osFinished = gson.fromJson(reader, ArrayList.class);
            osFinished.add(technician.getOs());
            technician.setOs(null);
            tec.updateTechnicianOs(technician, technician.getOs());
            String updateJson = gson.toJson(osFinished);
            FileWriter writer = new FileWriter(fileFinished);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else{
            osFinishedList.add(technician.getOs());
            technician.setOs(null);
            tec.updateTechnicianOs(technician, technician.getOs());
            String finishedJson = gson.toJson(osFinishedList);
            FileWriter writer = new FileWriter(fileFinished);
            writer.write(finishedJson);
            writer.flush();
            writer.close();
        }
    }

    /**
     *
     */
    public Queue<Os> readOsQueue() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
        Queue<Os> queue1 = gson.fromJson(reader, new TypeToken<Queue<Os>>(){}.getType());
        return queue1;
        }

    public ArrayList<Os> readOsCanceled() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osCanceled.json"));
        ArrayList<Os> osCanceleds = gson.fromJson(reader, new TypeToken<ArrayList<Os>>(){}.getType());
        return osCanceleds;
    }

    public ArrayList<Os> readOsFinished() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osFinished.json"));
        ArrayList<Os> osFinisheds = gson.fromJson(reader, new TypeToken<ArrayList<Os>>(){}.getType());
        return osFinisheds;
    }

    public void deleteOsInQueue() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Queue<Os> queueFromJson = readOsQueue();
        queueFromJson.remove();
        String queueToJson = gson.toJson(queueFromJson);
        FileWriter writer = new FileWriter("osQueue.json");
        writer.write(queueToJson);
        writer.close();
    }

    public void deleteOsInCanceledList(Os os) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Os> canceledFromJson = readOsCanceled();
        canceledFromJson.remove(os);
        String canceledToJson = gson.toJson(canceledFromJson);
        FileWriter writer = new FileWriter("osCanceled.json");
        writer.write(canceledToJson);
        writer.close();
    }

    public void deleteOsInFinishedList(Os os) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Os> finishedFromJson = readOsFinished();
        finishedFromJson.remove(os);
        String finishedToJson = gson.toJson(finishedFromJson);
        FileWriter writer = new FileWriter("osFinished.json");
        writer.write(finishedToJson);
        writer.close();
    }



}

