###########################################################################################
# File: HC_samples.R
# Description: R module for higher order analysis tools - hierarchical clustering
# Author: Huaitian Liu
# Date: August 2005
###########################################################################################

# Clustering over samples 
mycluster <- function(x, diss=c("Correlation", "Euclidean"), meth=c("average","single","complete"), filename) {
    library(cluster)
    
    # Clustering over samples
    png(filename="samplecluster%d.png")
    if (diss=='Correlation') 
    sampclst <- hclust(as.dist(1 - cor(x,use="pair")), method=meth)

    plot(sampclst, labels=arraylab, xlab="", ylab="",cex=.5,sub="", hang=-1)
    mtext(paste("1-correlation",meth), side=2,line=3,cex=.8)
    #title("Clustering over the samples", font=1,cex=0.5)

    if (diss=='Euclidean') {
    sampclst<- hclust(dist(t(x)),method=meth)
    plot(sampclst, labels=arraylab, xlab="", ylab="", cex=.5,sub="", hang=-1)
    mtext(paste("Euclidean",meth), side=2,line=3,cex=.8)
    #title("Clustering over the samples", font=1,cex=0.5)
    }
    dev.off()
}
