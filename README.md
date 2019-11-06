# android-eservices-webrequests

Ce TP est le dernier de la série pour le cours d'Android cette année.
Il est plus important que les précédents et mélange plusieurs notions.
Il fait suite au cours sur RxJava, Retrofit et Gson.

### Description
Cette application permet de rechercher un livre via l'API books de Google et de le marquer comme favori.
Ces favoris sont stockés localement sur l'ordinateur dans une base de données Room. 
A tout moment il est possible de retirer un livre de ses favoris.

### Aspects techniques
L'application respecte le principe de Clean Architecture [recommandée par Android](https://developer.android.com/jetpack/docs/guide#recommended-app-arch). 

L'application utilise l'architecture MVP en deux couches (présentation et donnée), présentée [ici](https://android.jlelse.eu/architectural-guidelines-to-follow-for-mvp-pattern-in-android-2374848a0157)

Les appels réseau sont effectués via Retrofit sur l'API Books.
Toutes les infos sur l'API peuvent être trouvées [ici](https://developers.google.com/books/docs/v1/using). 
**Attention, il faudra vous créer une clé qui vous autorise à utiliser l'API, pour cela, lisez [ça](https://cloud.google.com/docs/authentication/api-keys?visit_id=637031972070460939-2253245193&rd=1).** 


Les flux de données de l'application sont gérés avec [RxJava 2](https://github.com/ReactiveX/RxJava). 


Jettez un oeil à la classe Application ? A quoi sert-elle ?


### Objectifs
Ce TP est découpé en deux partie qui se suivent, faites d'abord l'une puis l'autre.

###### Première partie : les appels réseau
Premier objectif, pouvoir récupérer les livres correspondant à la recherche de l'utilisateur.
Pour ça tout est à mettre en place :
- [x] Préparer l'architecture
- [ ] Créer l'interface Retrofit et mettre en place la méthode permettant de fournir une instance du service dans notre fausse DI.
- [ ] Créer les differents Repository et DataSources avec les bonnes méthodes qui seront appelées depuis le Presenter.
- [ ] Créer le Presenter pour le fragment de recherche en respectant le contrat entre vue et Presenter.
- [ ] Préparer le mapper qui prépare les objets reçus dans le Presenter à être affichés dans la vue.
- [ ] Initialiser et appeler le Presenter depuis la vue.

###### Deuxième partie : les favoris
Maintenant que l'on sait faire des recherches, on souhaite pouvoir gérer les favoris. 
On peut ajouter et retirer des favoris facilement.
Ces favoris vont être stockés dans une base de données Android Room.
Pour faire ça il va falloir :
- [ ] Mettre en place la BDD, l'entité livre, et préparer la méthode qui permet de fournir une instance Singleton de la BDD.
- [ ] Mettre à jour la partie Repository en créant les méthodes de récupération et suppression de favoris.
- [ ] Ecrire l'algorithme qui permet de transformer les résultats de la recherche en indiquant ceux qui sont déjà en favoris.
- [ ] Créer le Presenter pour la partie Favoris et le lier à la vue.
- [ ] Tester tout ça, utiliser [Stetho](http://facebook.github.io/stetho/) 