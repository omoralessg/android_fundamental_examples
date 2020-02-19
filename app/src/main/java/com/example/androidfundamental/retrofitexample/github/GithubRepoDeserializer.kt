package com.example.androidfundamental.retrofitexample.github

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class GithubRepoDeserializer : JsonDeserializer<GithubRepo> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): GithubRepo {
        val githubRepo = GithubRepo()
        val repoJsonObject = json.asJsonObject
        githubRepo.name = repoJsonObject["name"].asString
        githubRepo.url = repoJsonObject["url"].asString
        val ownerJsonElement = repoJsonObject["owner"]
        val ownerJsonObject = ownerJsonElement.asJsonObject
        githubRepo.owner = ownerJsonObject["login"].asString
        return githubRepo
    }
}